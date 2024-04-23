package com.base64.gamesback.category.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SaveCategoryDto {

    @Size(min = 2, max = 50)
    @JsonProperty(value = "category_name")
    private String categoryName;
}
