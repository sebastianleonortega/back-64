package com.base64.gamesback.commerce.commerce.repository;

import com.base64.gamesback.commerce.commerce.entity.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommerceRepository extends JpaRepository<Commerce, UUID> {

    Commerce getCommerceByCommerceId(UUID commerceId);
}
