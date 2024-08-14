package com.pcanabarro.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UrlUpdateRequestDTO {
    @Column(name = "id")
    private long id;

    @JsonProperty("original_url")
    @Column(name = "original_url")
    private String originalUrl;

    @JsonProperty("short_url")
    @Column(name = "short_url")
    private String shortUrl;

    public boolean isValid() {
        return originalUrl != null && shortUrl != null;
    }
}
