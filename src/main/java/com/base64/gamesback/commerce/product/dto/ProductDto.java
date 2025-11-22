package com.base64.gamesback.commerce.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Getter
@NoArgsConstructor
public class ProductDto {

    @JsonIgnore
    private UUID productId;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "code")
    private Integer code;

    @JsonProperty(value = "price")
    private BigDecimal price;

    @JsonProperty(value = "stock")
    private Integer stock;

    @JsonProperty(value = "image")
    private String image;

    @JsonProperty(value = "category_id")
    private UUID categoryId;

    @JsonProperty(value = "commerce_id")
    private UUID commerceId;

    @JsonProperty(value = "tax_id")
    private List<String> taxes;

    public ProductDto(UUID productId, String name, String description, Integer code, BigDecimal price, Integer stock, String image, UUID categoryId, UUID commerceId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.code = code;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.categoryId = categoryId;
        this.commerceId = commerceId;
    }

    public void updateTaxes(List<String> taxes) {
        this.taxes = taxes;
    }
}
