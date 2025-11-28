package com.base64.gamesback.commerce.commerce.repository.impl;

import com.base64.gamesback.commerce.commerce.dto.CommerceDto;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.commerce.entity.Commerce_;
import com.base64.gamesback.commerce.commerce.repository.CommerceCriteriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class CommerceRepositoryImpl implements CommerceCriteriaRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<CommerceDto> getAllCommerce() {
        List<CommerceDto> result = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try {
            CriteriaQuery<CommerceDto> cq = cb.createQuery(CommerceDto.class);
            Root<Commerce> root = cq.from(Commerce.class);

            cq.select(
                    cb.construct(
                            CommerceDto.class,
                            root.get(Commerce_.name),
                            root.get(Commerce_.nit),
                            root.get(Commerce_.address),
                            root.get(Commerce_.email),
                            root.get(Commerce_.phone),
                            root.get(Commerce_.status)
                    )
            );
            result = em.createQuery(cq).getResultList();
        } catch (Exception ex) {
            log.error("Error en la criteria ListAllCommerce [{}]", ex.getMessage());
        }
        return result;
    }
}
