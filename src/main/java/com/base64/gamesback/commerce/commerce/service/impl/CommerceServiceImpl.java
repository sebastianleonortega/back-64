package com.base64.gamesback.commerce.commerce.service.impl;

import com.base64.gamesback.commerce.commerce.dto.CommerceDto;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.commerce.repository.CommerceRepository;
import com.base64.gamesback.commerce.commerce.service.CommerceService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommerceServiceImpl implements CommerceService {

    private final CommerceRepository commerceRepository;

    public CommerceServiceImpl(CommerceRepository commerceRepository) {
        this.commerceRepository = commerceRepository;
    }


    @Override
    public Commerce GetCommerceById(UUID id) {
       return commerceRepository.findById(id).orElseThrow(()-> new RuntimeException("No existe el commerce."));
    }

    @Override
    public void createCommerce(CommerceDto request) {
        Commerce commerce = Commerce.create(
                request.getName(),
                request.getNit(),
                request.getAddress(),
                request.getEmail(),
                request.getPhone()
        );
        commerceRepository.save(commerce);
    }
}
