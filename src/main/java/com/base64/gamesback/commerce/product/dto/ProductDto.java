package com.base64.gamesback.commerce.product.dto;

import com.base64.gamesback.commerce.tax.entity.Tax;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;
import java.util.UUID;


@Getter
public class ProductDto {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "code")
    private Number code;

    @JsonProperty(value = "price")
    private Number price;

    @JsonProperty(value = "stock")
    private Number stock;

    @JsonProperty(value = "image")
    private String image;

    @JsonProperty(value = "category_id")
    private UUID categoryId;

    @JsonProperty(value = "commerce_id")
    private UUID commerceId;

    @JsonProperty(value = "tax_id")
    private List<String> taxes;

    public ProductDto(String name, String description, Number code, Number price, Number stock, String image, UUID categoryId, UUID commerceId, List<String> taxes) {
        this.name = name;
        this.description = description;
        this.code = code;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.categoryId = categoryId;
        this.commerceId = commerceId;
        this.taxes = taxes;
    }
}
