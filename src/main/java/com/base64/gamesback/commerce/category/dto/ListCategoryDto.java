package com.base64.gamesback.commerce.category.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class ListCategoryDto {

    @JsonProperty(value = "category_id")
    private UUID id;

    @JsonProperty(value = "name")
    private String name;

    public ListCategoryDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
