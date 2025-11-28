package com.base64.gamesback.commerce.tax.service;

import com.base64.gamesback.commerce.tax.dto.TaxDto;
import com.base64.gamesback.commerce.tax.entity.Tax;

import java.util.List;
import java.util.UUID;

public interface TaxService {

    TaxDto findTaxById(UUID uuid);

    List<Tax> getTaxesById(List<String> uuids);

    void createTax(TaxDto taxDto);

    void updateTax(UUID uuid, TaxDto taxDto);

    void deleteTax(UUID uuid);

    List<String> getAllTaxesIdByProductId(UUID productId);
}
