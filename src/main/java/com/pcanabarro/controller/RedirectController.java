package com.pcanabarro.controller;

import com.pcanabarro.entity.Url;
import com.pcanabarro.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Component
@RestController
@RequestMapping("/")
public class RedirectController {
    private final UrlService urlService;

    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping
    public ResponseEntity<String> index() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello World");
    }

    @GetMapping("/{shortcut}")
    public ResponseEntity<URI> getShortcut(@PathVariable String shortcut) {
        Url url = urlService.getUrlByShortUrl(shortcut);
        URI redirectUri = URI.create(url.getOriginalUrl());

        return ResponseEntity.status(HttpStatus.FOUND).location(redirectUri).build();
    }
}
