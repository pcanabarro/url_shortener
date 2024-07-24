package com.pcanabarro.controller;

import com.pcanabarro.responses.UrlResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
public class UrlController {
    @Value("${app.name}")
    private String appName;

    @GetMapping("/")
    public String getUrl() {
        return appName;
    }

    @GetMapping("/{url}")
    public String getUrl(@PathVariable String url) {
        return "my url " + url;
    }

    @GetMapping("/json")
    public UrlResponse getJson() {
        return new UrlResponse(1, "https://github.com/pcanabarro", "pc");
    }
}
