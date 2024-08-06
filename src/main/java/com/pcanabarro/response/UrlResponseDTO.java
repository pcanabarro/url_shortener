package com.pcanabarro.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pcanabarro.entity.Url;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UrlResponseDTO {
    @JsonProperty("id")
    long id;

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
