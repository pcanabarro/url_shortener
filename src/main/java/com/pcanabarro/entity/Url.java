package com.pcanabarro.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pcanabarro.request.UrlRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "short_url")
    private String shortUrl;

    public Url(UrlRequestDTO urlRequestDTO) {
        this.originalUrl =  urlRequestDTO.getOriginalUrl();
        this.shortUrl = urlRequestDTO.getShortUrl();
    }
}
