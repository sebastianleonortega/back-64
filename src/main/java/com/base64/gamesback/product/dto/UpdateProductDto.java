package com.base64.gamesback.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UpdateProductDto {

    @NotNull
    @JsonProperty(value = "product_name")
    private String productName;

    @NotNull
    @JsonProperty(value = "product_description")
    private String productDescription;

    @NotNull
    @JsonProperty(value = "product_qualification")
    private Number productQualification;

    @NotNull
    @Size(min = 4, max = 4)
    @JsonProperty(value = "product_year")
    private String productYear;

    @JsonProperty(value = "product_image")
    private String productImage;

    @JsonProperty(value = "category_id")
    private UUID categoryId;
}
