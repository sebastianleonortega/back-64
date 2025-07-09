package com.base64.gamesback.commerce.tax.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TaxDto {

    @JsonProperty(value = "tax_id")
    private String taxId;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "description")
    private String description;


}
