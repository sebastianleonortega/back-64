package com.base64.gamesback.commerce.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.UUID;


@Getter
public class ProductDto {

    @NotNull
    @JsonProperty(value = "name")
    private String name;

    @NotNull
    @JsonProperty(value = "description")
    private String description;

    @NotNull
    @JsonProperty(value = "code")
    private Number code;

    @JsonProperty(value = "price")
    private Number price;

    @NotNull
    @JsonProperty(value = "stock")
    private Number stock;

    @JsonProperty(value = "image")
    private String image;

    @JsonProperty(value = "category_id")
    private UUID categoryId;

    @JsonProperty(value = "commerce_id")
    private UUID commerceId;

}
