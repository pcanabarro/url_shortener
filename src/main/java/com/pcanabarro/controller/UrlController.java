package com.pcanabarro.controller;

import com.pcanabarro.entity.Url;
import com.pcanabarro.request.RandomUrlRequestDTO;
import com.pcanabarro.request.UrlRequestDTO;
import com.pcanabarro.response.UrlResponseDTO;
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

    @Value("${app.router}")
    private String appRouter;


    @GetMapping("/")
    public String getUrl() {
        return appName;
    }

    @GetMapping("/all")
    public List<UrlResponseDTO> getAllUrl() {
        List<Url> allUrls = urlService.getAllUrls();
        List<UrlResponseDTO> urlResponseList = new ArrayList<>();

        for (Url url : allUrls) {
            urlResponseList.add(new UrlResponseDTO(url));
        }

        return urlResponseList;
    }

    @GetMapping("/{id}")
    public UrlResponseDTO getUrlById(@PathVariable Long id) {
        Url url = urlService.getUrlById(id);

        return new UrlResponseDTO(url);
    }

    @PostMapping("/")
    public String createUrl(@RequestBody UrlRequestDTO urlRequestDTO) {
        if (!urlRequestDTO.isValid()) {
            return "Invalid POST request creating url!";
        }

        Url urlToSave = new Url(urlRequestDTO);
        urlService.createUrl(urlToSave);

        return "URL created, your shortcut is" + appRouter + urlToSave.getShortUrl();
    }

    @PostMapping("/random")
    public String createRandomUrl(@RequestBody RandomUrlRequestDTO randomUrlRequestDTO) {
        if (!randomUrlRequestDTO.isValid()) {
            return "Invalid POST request creating random url!";
        }

        Url urlToSave = new Url(randomUrlRequestDTO);
        urlService.createUrl(urlToSave);

        return "Random URL created, your shortcut is " + appRouter + urlToSave.getShortUrl();
    }
}
