package com.viskei.alpha.services;

import com.viskei.alpha.model.Exchange;

public interface ExchangeService {
    boolean compareExchanges(Exchange exchange1, Exchange exchange2, String currency);
}
