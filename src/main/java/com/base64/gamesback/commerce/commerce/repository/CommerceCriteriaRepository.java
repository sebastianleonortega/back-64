package com.base64.gamesback.commerce.commerce.repository;

import com.base64.gamesback.commerce.commerce.dto.CommerceDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommerceCriteriaRepository  {

    List<CommerceDto> getAllCommerce();
}
