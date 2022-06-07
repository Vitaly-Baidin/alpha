package com.viskei.alpha.controllers;

import com.viskei.alpha.clients.ExchangeClient;
import com.viskei.alpha.clients.GifClient;
import com.viskei.alpha.model.Exchange;
import com.viskei.alpha.model.Gif;
import com.viskei.alpha.services.ExchangeService;
import com.viskei.alpha.services.URIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ExchangeController {
    private final URIService uriService;
    private final ExchangeService exchangeService;
    private final ExchangeClient exchangeClient;
    private final GifClient gifClient;

    @Value("${exchange.server}")
    private String exchangeServer;
    @Value("${exchange.app_id}")
    private String exchangeAppId;
    @Value("${exchange.currency}")
    private String exchangeCurrency;
    @Value("${gif.server}")
    private String gifServer;
    @Value("${gif.app_id}")
    private String gifAppId;
    @Value("${gif.more}")
    private String more;
    @Value("${gif.less}")
    private String less;


    @Autowired
    public ExchangeController(URIService uriService, ExchangeService exchangeService, ExchangeClient exchangeClient, GifClient gifClient) {
        this.uriService = uriService;
        this.exchangeService = exchangeService;
        this.exchangeClient = exchangeClient;
        this.gifClient = gifClient;
    }

    @GetMapping("/")
    public Gif getDefault() {
        return getGifJSON(exchangeCurrency);
    }

    @GetMapping("/{currency}")
    public Gif getGifJSON(@PathVariable String currency) {

        Exchange exchangeNow = exchangeClient.getExchange(uriService.getExchangeURI(exchangeServer, exchangeAppId, currency, LocalDateTime.now()));
        Exchange exchangeYesterday = exchangeClient.getExchange(uriService.getExchangeURI(exchangeServer, exchangeAppId, currency, LocalDateTime.now().minusDays(1)));

        String tag = exchangeService.compareExchanges(exchangeNow, exchangeYesterday, exchangeCurrency) ? more : less;

        Gif gif = gifClient.getGif(uriService.getGifURI(gifServer, gifAppId, tag));

        return gif;
    }
}
