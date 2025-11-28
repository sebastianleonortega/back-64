package com.base64.gamesback.commerce.tax.repository;

import com.base64.gamesback.commerce.tax.dto.TaxDto;

import java.util.List;

public interface TaxCriteriaRepository {

    List<TaxDto> getAllTaxes();
}
