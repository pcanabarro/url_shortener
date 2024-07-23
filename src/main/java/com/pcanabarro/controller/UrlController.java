package com.pcanabarro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    @GetMapping("/")
    public String getUrl() {
        return "my url";
    }

    @GetMapping("/{url}")
    public String getUrl(@PathVariable String url) {
        return "my url " + url;
    }

}
