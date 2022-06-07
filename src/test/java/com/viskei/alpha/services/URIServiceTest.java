package com.viskei.alpha.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.net.URI;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class URIServiceTest {

    @Autowired
    private URIService uriService;

    @Value("${gif.server}")
    private String gifServer;
    @Value("${gif.app_id}")
    private String gifAppId;
    @Value("${gif.more}")
    private String gifMore;
    @Value("${gif.more}")
    private String gifLess;

    @Value("exchange.server")
    private String exchangeServer;

    @Value("exchange.app_id")
    private String exchangeAppId;

    @Value("exchange.currency")
    private String exchangeCurrency;

    StringBuilder builderURL = new StringBuilder();

    @BeforeEach
    void init() {

    }

    @Test
    void getExchangeURI() {
        URI expected = URI.create(builderURL.append(exchangeServer)
                .append("latest.json?app_id=").append(exchangeAppId)
                .append("&base=").append(exchangeCurrency.toUpperCase())
                .toString());

        URI actual = uriService.getExchangeURI(exchangeServer, exchangeAppId, exchangeCurrency, LocalDateTime.now());

        assertEquals(expected, actual);
    }

    @Test
    void getGifURIIfMore() {
        URI expected = URI.create(builderURL.append(gifServer)
                .append("v1/gifs/random?api_key=").append(gifAppId)
                .append("&tag=").append(gifMore)
                .toString());

        URI actual = uriService.getGifURI(gifServer, gifAppId, gifMore);

        assertEquals(expected, actual);
    }

    @Test
    void getGifURIIfLess() {
        URI expected = URI.create(builderURL.append(gifServer)
                .append("v1/gifs/random?api_key=").append(gifAppId)
                .append("&tag=").append(gifLess)
                .toString());

        URI actual = uriService.getGifURI(gifServer, gifAppId, gifLess);

        assertEquals(expected, actual);
    }
}