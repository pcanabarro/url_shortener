package com.pcanabarro.controller;

import com.pcanabarro.entity.Url;
import com.pcanabarro.responses.UrlResponse;
import com.pcanabarro.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/api/url")
public class UrlController {
    @Autowired
    private UrlService urlService;

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

    @GetMapping("/all")
    public List<UrlResponse> getAllUrl() {
        List<Url> urls = urlService.getAllUrls();
        List<UrlResponse> urlResponseList = new ArrayList<UrlResponse>();

        for (Url url : urls) {
            urlResponseList.add(new UrlResponse(url));
        }

        return urlResponseList;
    }

    @PostMapping("/")
    public Url createUrl(@RequestBody Url url) {
        return urlService.createUrl(url);
    }
}
