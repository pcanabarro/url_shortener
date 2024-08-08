package com.pcanabarro.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseDTO {
    @JsonProperty("code")
    private int httpResponseCode;

    @JsonProperty("message")
    private String errorMessage;

    @JsonProperty("error")
    private String errorDetails;
}
