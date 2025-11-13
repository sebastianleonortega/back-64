package com.base64.gamesback.commerce.commerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ActivateCommerceDto {

    @NotBlank
    @JsonProperty(value = "name")
    public String name;

    @JsonProperty(value = "email")
    public String email;

    public ActivateCommerceDto( String name, String email) {
        this.name = name;
        this.email = email;
    }
}
