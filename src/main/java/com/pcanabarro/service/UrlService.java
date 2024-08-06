package com.pcanabarro.service;

import com.pcanabarro.entity.Url;
import com.pcanabarro.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    UrlRepository urlRepository;

    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    public void createUrl(Url url) {
        urlRepository.save(url);
    }
}
