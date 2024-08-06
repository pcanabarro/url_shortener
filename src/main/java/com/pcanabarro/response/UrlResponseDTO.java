package com.pcanabarro.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pcanabarro.entity.Url;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlResponseDTO {
    @JsonProperty("id")
    Long id;

    @JsonProperty("original_url")
    String originalUrl;

    @JsonProperty("short_url")
    String shortUrl;

    public UrlResponseDTO(Url url) {
        this.id = url.getId();
        this.originalUrl = url.getOriginalUrl();
        this.shortUrl = url.getShortUrl();
    }
}
