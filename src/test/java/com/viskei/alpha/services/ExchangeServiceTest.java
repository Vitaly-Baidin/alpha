package com.viskei.alpha.services;

import com.viskei.alpha.model.Exchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ExchangeServiceTest {

    @Autowired
    private ExchangeService exchangeService;

    Exchange exchangeNow;
    Exchange exchangeYesterday;

    Map<String, Double> exchange1Map = new HashMap<>();
    Map<String, Double> exchange2Map = new HashMap<>();

    @BeforeEach
    void init() {

        exchange1Map.put("RUB", 61.48);
        exchange2Map.put("RUB", 62.48);

        exchangeNow = new Exchange("Disclaimer", "License", "USD", exchange1Map);
        exchangeYesterday = new Exchange("Disclaimer", "License", "USD", exchange2Map);
    }

    @Test
    void compareExchangesMore() {
        Assertions.assertFalse(exchangeService.compareExchanges(exchangeNow, exchangeYesterday, "RUB"));
    }
    @Test
    void compareExchangesLess() {
        Assertions.assertTrue(exchangeService.compareExchanges(exchangeYesterday, exchangeNow, "RUB"));
    }
    @Test
    void compareExchangesEquals() {
        Assertions.assertFalse(exchangeService.compareExchanges(exchangeNow, exchangeNow, "RUB"));
    }
}