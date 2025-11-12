package com.base64.gamesback.commerce.category.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryDto {

    @Size(min = 2, max = 50)
    @JsonProperty(value = "name")
    private String name;

    public CategoryDto(String name) {
        this.name = name;
    }
}
