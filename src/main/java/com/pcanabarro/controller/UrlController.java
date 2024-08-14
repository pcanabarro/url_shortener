package com.pcanabarro.controller;

import com.pcanabarro.entity.Url;
import com.pcanabarro.request.RandomUrlRequestDTO;
import com.pcanabarro.request.UrlRequestDTO;
import com.pcanabarro.request.UrlUpdateRequestDTO;
import com.pcanabarro.response.UrlResponseDTO;
import com.pcanabarro.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/api/url")
public class UrlController {
    private final UrlService urlService;

    Logger log = LoggerFactory.getLogger(UrlController.class);

    @Value("${app.name}")
    private String appName;

    @Value("${app.router}")
    private String appRouter;


    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getUrl() {
        log.info("Get url called");
        return ResponseEntity.status(HttpStatus.OK).body(appName);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UrlResponseDTO>> getAllUrl() {
        List<Url> allUrls = urlService.getAllUrls();
        List<UrlResponseDTO> urlResponseList = new ArrayList<>();

        allUrls.forEach(url -> urlResponseList.add(new UrlResponseDTO(url)));

        return ResponseEntity.status(HttpStatus.OK).body(urlResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UrlResponseDTO> getUrlById(@PathVariable Long id) {
        Url url = urlService.getUrlById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new UrlResponseDTO(url));
    }

    @GetMapping("/query/{id}")
    public ResponseEntity<UrlResponseDTO> getUrlByIdQuery(@PathVariable Long id) {
        Url url = urlService.getUrlByIdQuery(id);

        return ResponseEntity.status(HttpStatus.OK).body(new UrlResponseDTO(url));
    }

    @PostMapping("/")
    public String createUrl(@RequestBody UrlRequestDTO urlRequestDTO) {
        if (!urlRequestDTO.isValid()) {
            log.error("Error creating url at {}", urlRequestDTO);
            return "Invalid POST request creating url!";
        }

        Url urlToSave = new Url(urlRequestDTO);
        urlService.createUrl(urlToSave);

        return "URL created, your shortcut is " + appRouter + urlToSave.getShortUrl();
    }

    @PostMapping("/random")
    public String createRandomUrl(@RequestBody RandomUrlRequestDTO randomUrlRequestDTO) {
        if (!randomUrlRequestDTO.isValid()) {
            log.error("Error creating random url at {}", randomUrlRequestDTO);
            return "Invalid POST request creating random url!";
        }

        Url urlToSave = new Url(randomUrlRequestDTO);
        urlService.createUrl(urlToSave);

        return "Random URL created, your shortcut is " + appRouter + urlToSave.getShortUrl();
    }

    @PutMapping("/")
    public ResponseEntity<UrlResponseDTO> updateUrl(@RequestBody UrlUpdateRequestDTO urlUpdateRequestDTO) {
        if (!urlUpdateRequestDTO.isValid()) {
            log.error("Error updating url at {}", urlUpdateRequestDTO);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Url urlToUpdate = new Url(urlUpdateRequestDTO);
        urlService.updateUrl(urlToUpdate);

        return ResponseEntity.status(HttpStatus.OK).body(new UrlResponseDTO(urlToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUrl(@PathVariable long id) {
        urlService.deleteUrl(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Url with id " + id + " was deleted");
    }
}
