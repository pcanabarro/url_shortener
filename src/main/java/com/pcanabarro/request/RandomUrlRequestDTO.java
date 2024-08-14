package com.pcanabarro.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RandomUrlRequestDTO {
    @JsonProperty("original_url")
    @Column(name = "original_url")
    private String originalUrl;

    public boolean isValid() {
        return originalUrl != null;
    }
}
