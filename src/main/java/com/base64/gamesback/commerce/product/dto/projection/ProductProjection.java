package com.base64.gamesback.commerce.product.dto.projection;

import java.util.UUID;

public interface ProductProjection {

    String getName();

    String getDescription();

    Number getCode();

    Number getPrice();

    Number getStock();

    String getImage();

    UUID getCategoryId();

    UUID getCommerceId();

}
