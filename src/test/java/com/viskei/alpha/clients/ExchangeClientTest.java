package com.viskei.alpha.clients;

import com.viskei.alpha.model.Exchange;
import com.viskei.alpha.services.URIService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ExchangeClientTest {
    @Value("${exchange.server}")
    private String server;
    @Value("${exchange.app_id}")
    private String appId;
    @Value("${exchange.currency}")
    private String currency;

    @Autowired
    public URIService uriService;
    @Autowired
    public ExchangeClient exchangeClient;

    @Test
    void getExchange() {
        Exchange exchange = exchangeClient.getExchange(uriService.getExchangeURI(server, appId, currency, LocalDateTime.now()));
        Assertions.assertNotNull(exchange);
    }
}