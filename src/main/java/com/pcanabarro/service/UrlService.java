package com.pcanabarro.service;

import com.pcanabarro.entity.Url;
import com.pcanabarro.repository.UrlRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Url updateUrl(Url urlToUpdate) {
        Url url = urlRepository.findById(urlToUpdate.getId());

        if (url == null) {
            throw new EntityNotFoundException("Url id not found");
        }

        url.setOriginalUrl(urlToUpdate.getOriginalUrl());
        url.setShortUrl(urlToUpdate.getShortUrl());

        return urlRepository.save(url);
    }

    public boolean deleteUrl(long id) {
        Url url = urlRepository.findById(id);

        if (url == null) {
            return false;
        }

        urlRepository.delete(url);
        return true;
    }
}
