package com.pcanabarro.controller;

import com.pcanabarro.entity.Url;
import com.pcanabarro.service.UrlService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Component
@RestController
@RequestMapping("/")
public class RedirectController {
    private final UrlService urlService;

    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping
    public String index() {
        return "Hello World";
    }

    @GetMapping("/{shortcut}")
    public RedirectView getShortcut(@PathVariable String shortcut) {
        Url url = urlService.getUrlByShortUrl(shortcut);

        return new RedirectView(url.getOriginalUrl());
    }
}
