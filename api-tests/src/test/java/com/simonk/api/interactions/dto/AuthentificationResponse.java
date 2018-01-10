package com.simonk.api.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthentificationResponse {

    @JsonProperty
    private String token;

    public String getToken() {
        return token;
    }
}
