package com.base64.gamesback.commerce.product.repository;

import com.base64.gamesback.commerce.product.dto.ProductDto;
import com.base64.gamesback.common.criteria.Criteria;

import java.util.List;

public interface ProductRepositoryCustom {

    List<ProductDto> getProductsAll(Criteria criteria);
}
