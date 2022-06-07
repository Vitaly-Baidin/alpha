package com.viskei.alpha.clients;

import com.viskei.alpha.model.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "ExchangeRate", url = "https://openexchangerates.org/api/")
public interface ExchangeClient {
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Exchange getExchange(URI uri);
}