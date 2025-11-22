package com.base64.gamesback.commerce.tax.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TaxDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "description")
    private String description;

    public TaxDto(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
