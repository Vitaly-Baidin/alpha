package com.viskei.alpha.services.impl;

import com.viskei.alpha.services.URIService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class DefaultURIService implements URIService {

    @Override
    public URI getExchangeURI(String server, String appId, String currency, LocalDateTime date) {
        Assert.notNull(server,"[server] is null");
        Assert.notNull(appId,"[appId] is null");
        Assert.notNull(currency,"[currency] is null");
        Assert.notNull(date,"[date] is null");

        StringBuilder builderURL = new StringBuilder();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);

        if (date.toLocalDate().isEqual(LocalDate.now())) {
            builderURL.append(server)
                    .append("latest.json?app_id=").append(appId)
                    .append("&base=").append(currency.toUpperCase());

            return URI.create(builderURL.toString());
        }


        builderURL.append(server)
                .append("historical/").append(timeFormatter.format(date))
                .append(".json?app_id=").append(appId)
                .append("&base=").append(currency.toUpperCase());

        return URI.create(builderURL.toString());
    }

    @Override
    public URI getGifURI(String server, String apiId, String tag) {
        Assert.notNull(server,"[apiId] is null");
        Assert.notNull(apiId,"[apiId] is null");
        Assert.notNull(tag,"[tag] is null");

        StringBuilder builderURL = new StringBuilder();

        builderURL.append(server)
                .append("v1/gifs/random?api_key=").append(apiId)
                .append("&tag=").append(tag);

        return URI.create(builderURL.toString());
    }
}
