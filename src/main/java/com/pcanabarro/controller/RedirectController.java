package com.pcanabarro.controller;

import com.pcanabarro.entity.Url;
import com.pcanabarro.response.ErrorResponseDTO;
import com.pcanabarro.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public String index() {
        return "Hello World";
    }

    @GetMapping("/{shortcut}")
    public ResponseEntity<?> getShortcut(@PathVariable String shortcut) {
        Url url = urlService.getUrlByShortUrl(shortcut);

        if (url == null) {
            ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(404, "Url Not Found", shortcut);
            return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
        }

        URI redirectUri = URI.create(url.getOriginalUrl());

        return ResponseEntity.status(HttpStatus.FOUND).location(redirectUri).build();
    }
}
