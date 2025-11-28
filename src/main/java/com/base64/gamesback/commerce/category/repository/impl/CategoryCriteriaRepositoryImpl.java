package com.base64.gamesback.commerce.category.repository.impl;

import com.base64.gamesback.commerce.category.dto.ListCategoryDto;
import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.category.entity.Category_;
import com.base64.gamesback.commerce.category.repository.CategoryCriteriaRepository;
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
public class CategoryCriteriaRepositoryImpl implements CategoryCriteriaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ListCategoryDto> getAllCategories() {
        List<ListCategoryDto> result = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try {
            CriteriaQuery<ListCategoryDto> cq = cb.createQuery(ListCategoryDto.class);
            Root<Category> root = cq.from(Category.class);

            cq.select(
                    cb.construct(
                            ListCategoryDto.class,
                            root.get(Category_.categoryId),
                            root.get(Category_.name)
                    )
            ).orderBy(
                    cb.asc(root.get(Category_.name))
            );
            result = em.createQuery(cq).getResultList();
        } catch (Exception ex) {
            log.error("Error en la criteria listAllCategories [{}]", ex.getMessage());
        }
        em.close();
        return result;
    }
}
