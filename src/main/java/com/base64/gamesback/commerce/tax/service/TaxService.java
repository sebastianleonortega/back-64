package com.base64.gamesback.commerce.tax.service;

import com.base64.gamesback.commerce.tax.entity.Tax;

import java.util.List;
import java.util.UUID;

public interface TaxService {

 Tax getTaxById(UUID uuid);

 List<Tax> getTaxesById(List<String> uuids);
}
