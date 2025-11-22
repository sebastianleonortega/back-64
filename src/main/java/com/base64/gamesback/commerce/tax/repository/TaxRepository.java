package com.base64.gamesback.commerce.tax.repository;

import com.base64.gamesback.commerce.tax.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaxRepository extends JpaRepository<Tax, UUID> {

    List<Tax> findAllByTaxIdIn(List<UUID> uuids);

    boolean existsTaxByNameIgnoreCase(String name);

    boolean existsTaxByNameIgnoreCaseAndTaxIdNot(String name, UUID uuid);
}
