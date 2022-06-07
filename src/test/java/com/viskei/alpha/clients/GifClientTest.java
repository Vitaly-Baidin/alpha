package com.viskei.alpha.clients;

import com.viskei.alpha.model.Exchange;
import com.viskei.alpha.model.Gif;
import com.viskei.alpha.services.URIService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GifClientTest {
    @Value("${gif.server}")
    private String server;
    @Value("${gif.app_id}")
    private String appId;
    @Value("${gif.more}")
    private String more;

    @Autowired
    public URIService uriService;
    @Autowired
    public GifClient gifClient;

    @Test
    void getExchange() {
        Gif gif = gifClient.getGif(uriService.getGifURI(server, appId, more));
        Assertions.assertNotNull(gif);
    }
}