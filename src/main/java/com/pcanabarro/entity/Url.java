package com.pcanabarro.entity;

import com.pcanabarro.request.RandomUrlRequestDTO;
import com.pcanabarro.request.UrlRequestDTO;
import com.pcanabarro.request.UrlUpdateRequestDTO;
import com.pcanabarro.utils.RandomString;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

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
    private long id;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "short_url")
    private String shortUrl;

    @Value("${random.shortcut.integer}")
    private int shortcutInteger;


    public Url(UrlRequestDTO urlRequestDTO) {
        this.originalUrl =  urlRequestDTO.getOriginalUrl();
        this.shortUrl = urlRequestDTO.getShortUrl();
    }

    public Url(RandomUrlRequestDTO randomUrlRequestDTO) {
        this.originalUrl =  randomUrlRequestDTO.getOriginalUrl();
        this.shortUrl = RandomString.generateRandomString(shortcutInteger);
    }

    public Url(UrlUpdateRequestDTO urlUpdateRequestDTO) {
        this.id = urlUpdateRequestDTO.getId();
        this.originalUrl =  urlUpdateRequestDTO.getOriginalUrl();
        this.shortUrl = urlUpdateRequestDTO.getShortUrl();
    }
}
