package com.base64.gamesback.commerce.category.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SaveCategoryDto {

    @Size(min = 2, max = 50)
    @JsonProperty(value = "name")
    private String name;
}
