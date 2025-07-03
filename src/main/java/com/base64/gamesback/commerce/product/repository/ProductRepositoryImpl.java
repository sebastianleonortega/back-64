package com.base64.gamesback.commerce.product.repository;

import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.product.dto.ProductDto;
import com.base64.gamesback.commerce.product.entity.Product;
import com.base64.gamesback.common.criteria.Criteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductDto> getProductsAll(Criteria criteria) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        List<ProductDto> productDtos = new ArrayList<>();
        try {

            CriteriaQuery<ProductDto> criteriaQuery = builder.createQuery(ProductDto.class);
            Root<Product> root = criteriaQuery.from(Product.class);
            Join<Product, Category> categoryJoin = root.join("category");
            Join<Product, Commerce> commerceJoin = root.join("commerce");

            criteriaQuery.select(
                    builder.construct(
                            ProductDto.class,
                            root.get("name"),
                            root.get("description"),
                            root.get("code"),
                            root.get("price"),
                            root.get("stock"),
                            root.get("image"),
                            categoryJoin.get("categoryId"),
                            commerceJoin.get("commerceId")
                    )
            );

            TypedQuery<ProductDto> typedQuery = em.createQuery(criteriaQuery);

            productDtos = typedQuery.getResultList();

//            productDtos = em.createQuery(criteriaQuery).getResultList();


        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
        return productDtos;
    }
}
