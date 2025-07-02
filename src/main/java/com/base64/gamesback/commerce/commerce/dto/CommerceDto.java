package com.base64.gamesback.commerce.commerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CommerceDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "nit")
    private String nit;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "phone")
    private String phone;
}
