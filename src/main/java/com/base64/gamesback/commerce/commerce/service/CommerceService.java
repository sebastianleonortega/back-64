package com.base64.gamesback.commerce.commerce.service;

import com.base64.gamesback.commerce.commerce.dto.CommerceDto;
import com.base64.gamesback.commerce.commerce.entity.Commerce;

import java.util.List;
import java.util.UUID;

public interface CommerceService {

    CommerceDto findCommerceById(UUID id);

    Commerce getCommerceById(UUID id);

   void createCommerce(CommerceDto commerceDto);

   void updateCommerce(UUID id, CommerceDto commerceDto);

   void updateCommerceStatus(UUID id, String status);

   void deleteCommerceById(UUID id);

    List<CommerceDto> getAllCommerce();
}
