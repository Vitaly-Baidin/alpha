package com.viskei.alpha.services;

import java.net.URI;
import java.time.LocalDateTime;

public interface URIService {
    URI getExchangeURI(String server, String appId, String currency, LocalDateTime date);
    URI getGifURI(String server, String apiId, String tag);
}
