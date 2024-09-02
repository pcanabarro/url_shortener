package com.pcanabarro.controller;

import com.pcanabarro.entity.Url;
import com.pcanabarro.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/")
public class RedirectController {
    private static final Logger log = LoggerFactory.getLogger(RedirectController.class);
    private final UrlService urlService;
    public static List<String> redirectList = new ArrayList<>();

    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping
    public ResponseEntity<String> index() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello World" + redirectList);
    }

    @GetMapping("/{shortcut}")
    public ResponseEntity<URI> getShortcut(@PathVariable String shortcut) {
        Url url = urlService.getUrlByShortUrl(shortcut);

        if (url == null) {
            log.error("No url found for shortcut {}", shortcut);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        URI redirectUri = URI.create(url.getOriginalUrl());

        redirectList.add(url.getOriginalUrl());

        return ResponseEntity.status(HttpStatus.FOUND).location(redirectUri).build();
    }
}
