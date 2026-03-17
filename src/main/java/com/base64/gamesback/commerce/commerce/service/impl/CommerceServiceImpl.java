package com.base64.gamesback.commerce.commerce.service.impl;

import com.base64.gamesback.commerce.commerce.dto.ActivateCommerceDto;
import com.base64.gamesback.commerce.commerce.dto.CommerceDto;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.commerce.repository.CommerceCriteriaRepository;
import com.base64.gamesback.commerce.commerce.repository.CommerceRepository;
import com.base64.gamesback.commerce.commerce.service.CommerceService;
import com.base64.gamesback.common.email.service.EmailCommerceService;
import com.base64.gamesback.common.exception.AlreadyExistException;
import com.base64.gamesback.common.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CommerceServiceImpl implements CommerceService {

    private final CommerceRepository commerceRepository;
    private final CommerceCriteriaRepository commerceCriteriaRepository;
    private final EmailCommerceService emailCommerceService;

    public CommerceServiceImpl(CommerceRepository commerceRepository, CommerceCriteriaRepository commerceCriteriaRepository, EmailCommerceService emailCommerceService) {
        this.commerceRepository = commerceRepository;
        this.commerceCriteriaRepository = commerceCriteriaRepository;
        this.emailCommerceService = emailCommerceService;
    }

    @Override
    public CommerceDto findCommerceById(UUID id) {
      return commerceRepository
              .findById(id)
              .map(commerce -> new CommerceDto(
                      commerce.getName(),
                      commerce.getNit(),
                      commerce.getAddress(),
                      commerce.getEmail(),
                      commerce.getPhone(),
                      commerce.getStatus())
              ).orElseThrow(()-> new ResourceNotFoundException("No existe el comercio."));
    }

    @Override
    public Commerce getCommerceById(UUID id) {
        return commerceRepository.findById(id).orElseThrow(() -> new  ResourceNotFoundException("No existe el comercio."));
    }

    @Override
    public void createCommerce(CommerceDto request) {
        if (commerceRepository.existsCommerceByNameIgnoreCase(request.getName().trim())) {
            throw new AlreadyExistException("Ya existe un comercio con este nombre.");
        }
        Commerce commerce = Commerce.create(
                request.getName(),
                request.getNit(),
                request.getAddress(),
                request.getEmail(),
                request.getPhone(),
                request.getStatus()
        );
        commerceRepository.save(commerce);
        ActivateCommerceDto activateCommerceDto = new ActivateCommerceDto(
                request.getName(),
                request.getEmail()
        );
        emailCommerceService.sendEmailActivation(activateCommerceDto);
    }

    @Override
    public void updateCommerce(UUID id, CommerceDto request) {
        if (commerceRepository.existsCommerceByNameIgnoreCaseAndCommerceIdNot(request.getName().trim(), id)) {
            throw new AlreadyExistException("Ya existe un comercio con este nombre.");
        }
        Commerce commerce = commerceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el comercio."));
        commerce.update(
                request.getName(),
                request.getNit(),
                request.getAddress(),
                request.getEmail(),
                request.getPhone(),
                request.getStatus()
        );
        commerceRepository.save(commerce);
    }

    @Override
    public void updateCommerceStatus(UUID id, String status) {
        Commerce commerce = commerceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el comercio."));


        commerce.updateStatus(status);
    }

    @Override
    public void deleteCommerceById(UUID id) {
       Commerce commerce = commerceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe el comercio."));
        commerceRepository.delete(commerce);
    }

    @Override
    public List<CommerceDto> getAllCommerce() {
        return commerceCriteriaRepository.getAllCommerce();
    }
}
