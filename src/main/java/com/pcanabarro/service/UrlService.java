package com.pcanabarro.service;

import com.pcanabarro.entity.Url;
import com.pcanabarro.repository.UrlRepository;
import com.pcanabarro.responses.UrlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    UrlRepository urlRepository;

    public List<Url> getAllUrls() {
        try {
            return urlRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error finding all: " + e);
        }
        return null;
    }

    public Url createUrl(Url url) {
        return urlRepository.save(url);
    }
}
