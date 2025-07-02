package com.base64.gamesback.commerce.commerce.service;

import com.base64.gamesback.commerce.commerce.dto.CommerceDto;
import com.base64.gamesback.commerce.commerce.entity.Commerce;

import java.util.UUID;

public interface CommerceService {

    Commerce GetCommerceById(UUID id);

   void createCommerce(CommerceDto commerceDto);
}
