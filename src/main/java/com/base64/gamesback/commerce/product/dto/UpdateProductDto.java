package com.base64.gamesback.commerce.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class UpdateProductDto {

    @NotNull
    @JsonProperty(value = "name")
    private String name;

    @NotNull
    @JsonProperty(value = "description")
    private String description;

    @NotNull
    @JsonProperty(value = "code")
    private Integer code;

    @JsonProperty(value = "price")
    private BigDecimal price;

    @NotNull
    @JsonProperty(value = "stock")
    private Integer stock;

    @JsonProperty(value = "image")
    private String image;

    @JsonProperty(value = "category_id")
    private UUID categoryId;
}
