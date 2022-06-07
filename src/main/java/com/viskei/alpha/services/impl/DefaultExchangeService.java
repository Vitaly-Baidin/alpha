package com.viskei.alpha.services.impl;

import com.viskei.alpha.model.Exchange;
import com.viskei.alpha.services.ExchangeService;
import org.springframework.stereotype.Service;

@Service
public class DefaultExchangeService implements ExchangeService {
    @Override
    public boolean compareExchanges(Exchange exchange1, Exchange exchange2, String currency) {
        return exchange1.getRates().get(currency.toUpperCase()) > exchange2.getRates().get(currency.toUpperCase());
    }
}
