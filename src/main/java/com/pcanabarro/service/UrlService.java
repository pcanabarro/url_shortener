package com.pcanabarro.service;

import com.pcanabarro.entity.Url;
import com.pcanabarro.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    public Url getUrlById(long id) {
        return urlRepository.findById(id);
    }

    public Url getUrlByShortUrl(String shortUrl) {
        return urlRepository.findByShortUrl(shortUrl);
    }

    public void createUrl(Url url) {
        urlRepository.save(url);
    }
}
