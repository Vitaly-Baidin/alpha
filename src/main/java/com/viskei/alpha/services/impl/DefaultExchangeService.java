package com.viskei.alpha.services.impl;

import com.viskei.alpha.model.Exchange;
import com.viskei.alpha.services.ExchangeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DefaultExchangeService implements ExchangeService {

    @Value("${gif.more}")
    private String more;
    @Value("${gif.less}")
    private String less;

    @Override
    public String compareExchanges(Exchange exchange1, Exchange exchange2, String currency) {
        return exchange1.getRates().get(currency.toUpperCase()) > exchange2.getRates().get(currency.toUpperCase()) ? more : less;
    }
}
