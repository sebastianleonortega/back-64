package com.base64.gamesback.commerce.tax.repository.impl;

import com.base64.gamesback.commerce.tax.dto.TaxDto;
import com.base64.gamesback.commerce.tax.entity.Tax;
import com.base64.gamesback.commerce.tax.entity.Tax_;
import com.base64.gamesback.commerce.tax.repository.TaxCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class TaxCriteriaRepositoryImpl implements TaxCriteriaRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<TaxDto> getAllTaxes() {
        List<TaxDto> result = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try {
            CriteriaQuery<TaxDto> cq = cb.createQuery(TaxDto.class);
            Root<Tax> root = cq.from(Tax.class);

            cq.select(
                    cb.construct(
                            TaxDto.class,
                            root.get(Tax_.name),
                            root.get(Tax_.description)
                    )
            ).orderBy(
                    cb.asc(root.get(Tax_.name))
            );
            result = em.createQuery(cq).getResultList();
        } catch (Exception ex) {
            log.error("Error en la criteria getAllTaxes [{}]", ex.getMessage());
        }
        em.close();
        return result;
    }
}
