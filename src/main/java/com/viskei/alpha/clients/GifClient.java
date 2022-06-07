package com.viskei.alpha.clients;

import com.viskei.alpha.model.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

@FeignClient(name = "Gif", url = "https://api.giphy.com/")
public interface GifClient {
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Gif getGif(URI uri);
}
