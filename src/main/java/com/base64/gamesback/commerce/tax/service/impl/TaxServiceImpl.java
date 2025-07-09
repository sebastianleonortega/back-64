package com.base64.gamesback.commerce.tax.service.impl;

import com.base64.gamesback.commerce.tax.dto.TaxDto;
import com.base64.gamesback.commerce.tax.entity.Tax;
import com.base64.gamesback.commerce.tax.repository.TaxRepository;
import com.base64.gamesback.commerce.tax.service.TaxService;
import com.base64.gamesback.common.exception_handler.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaxServiceImpl implements TaxService {

    private final TaxRepository taxRepository;

    public TaxServiceImpl(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Override
    public Tax getTaxById(UUID uuid) {
        return  taxRepository.findById(uuid).orElseThrow( () -> {return new ResourceNotFoundException("Tax not found");});
    }

    @Override
    public List<Tax> getTaxesById(List<String> request) {
        List<UUID> uuidList = request.stream().map(UUID::fromString).collect(Collectors.toList());
        return taxRepository.findAllByTaxIdIn(uuidList);
    }
}
