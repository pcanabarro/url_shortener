package com.pcanabarro.controller;

import com.pcanabarro.entity.Url;
import com.pcanabarro.request.UrlRequestDTO;
import com.pcanabarro.response.UrlResponseDTO;
import com.pcanabarro.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            return "Invalid POST request!";
        }
        
        Url urlToSave = new Url(urlRequestDTO);
        urlService.createUrl(urlToSave);

        return "Url created";
    }
}
