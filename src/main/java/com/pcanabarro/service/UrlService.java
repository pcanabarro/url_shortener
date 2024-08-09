package com.pcanabarro.service;

import com.pcanabarro.entity.Url;
import com.pcanabarro.exception.UrlNotFoundException;
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
        List<Url> urls = urlRepository.findByShortUrl(shortUrl);

        if (urls.isEmpty()) {
            throw new UrlNotFoundException("Cannot find url with shortcut: " + shortUrl);
        }

        return urls.getFirst();
    }

    public void createUrl(Url url) {
        urlRepository.save(url);
    }

    public void updateUrl(Url urlToUpdate) {
        Url url = urlRepository.findById(urlToUpdate.getId());

        if (url == null) {
            throw new UrlNotFoundException("Cannot find url with id: " + urlToUpdate.getId());
        }

        url.setOriginalUrl(urlToUpdate.getOriginalUrl());
        url.setShortUrl(urlToUpdate.getShortUrl());

        urlRepository.save(url);
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
