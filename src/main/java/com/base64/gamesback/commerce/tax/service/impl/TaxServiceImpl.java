package com.base64.gamesback.commerce.tax.service.impl;

import com.base64.gamesback.commerce.product.entity.Product;
import com.base64.gamesback.commerce.product.entity.Product_;
import com.base64.gamesback.commerce.tax.dto.TaxDto;
import com.base64.gamesback.commerce.tax.entity.Tax;
import com.base64.gamesback.commerce.tax.entity.Tax_;
import com.base64.gamesback.commerce.tax.repository.TaxRepository;
import com.base64.gamesback.commerce.tax.service.TaxService;
import com.base64.gamesback.common.exception.AlreadyExistException;
import com.base64.gamesback.common.exception.ResourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TaxServiceImpl implements TaxService {

    private final TaxRepository taxRepository;

    @PersistenceContext
    private EntityManager em;

    public TaxServiceImpl(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Override
    public TaxDto findTaxById(UUID uuid) {
        return taxRepository.findById(uuid).map(tax -> new TaxDto(
                tax.getName(),
                tax.getDescription())
        ).orElseThrow(() -> new ResourceNotFoundException("No existe este impuesto"));
    }

    @Override
    public List<Tax> getTaxesById(List<String> request) {
        List<UUID> uuidList = request.stream().map(UUID::fromString).collect(Collectors.toList());
        return taxRepository.findAllByTaxIdIn(uuidList);
    }

    @Override
    public void createTax(TaxDto request) {
        if (taxRepository.existsTaxByNameIgnoreCase(request.getName())) {
            throw new AlreadyExistException("Ya existe una impuesto con el nombre: " + request.getName());
        }
        Tax tax = Tax.create(
                request.getName(),
                request.getDescription()
        );
        taxRepository.save(tax);
    }

    @Override
    public void updateTax(UUID uuid, TaxDto request) {
        if (taxRepository.existsTaxByNameIgnoreCaseAndTaxIdNot(request.getName(), uuid)) {
            throw new AlreadyExistException("Ya existe una impuesto con el nombre: " + request.getName());
        }
        Tax tax = taxRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe este impuesto"));
        tax.update(
                request.getName(),
                request.getDescription()
        );
        this.taxRepository.save(tax);
    }

    @Override
    public void deleteTax(UUID uuid) {
        Tax tax = taxRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("No existe este impuesto"));
        taxRepository.delete(tax);
    }

    @Override
    public List<String> getAllTaxesIdByProductId(UUID productId) {
        List<String> result = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try {
            CriteriaQuery<String> cq = cb.createQuery(String.class);
            Root<Product> root = cq.from(Product.class);
            Join<Product, Tax> taxJoin = root.join(Product_.taxes);

            cq.select(
                    taxJoin.get(Tax_.taxId).as(String.class)
            ).where(
                    cb.equal(root.get(Product_.productId), productId)
            ).orderBy(
                    cb.asc(taxJoin.get(Tax_.name))
            );
            result = em.createQuery(cq).getResultList();
        } catch (Exception ex) {
            log.error("Error en la criteria getAllTaxesIdByProductId [{}]", ex.getMessage());
        }
        em.close();
        return result;
    }
}
