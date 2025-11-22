package com.base64.gamesback.commerce.product.repository.impl;

import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.category.entity.Category_;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.commerce.entity.Commerce_;
import com.base64.gamesback.commerce.product.dto.ProductDto;
import com.base64.gamesback.commerce.product.entity.Product;
import com.base64.gamesback.commerce.product.entity.Product_;
import com.base64.gamesback.commerce.product.repository.ProductCriteriaRepository;
import com.base64.gamesback.commerce.tax.service.TaxService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Slf4j
@Repository
public class ProductRepositoryImpl implements ProductCriteriaRepository {

    private final TaxService taxService;

    @PersistenceContext
    private EntityManager em;

    public ProductRepositoryImpl(TaxService taxService) {
        this.taxService = taxService;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<ProductDto> result = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try {
            CriteriaQuery<ProductDto> cq = cb.createQuery(ProductDto.class);
            Root<Product> root = cq.from(Product.class);
            Join<Product, Category> categoryJoin = root.join(Product_.category);
            Join<Product, Commerce> commerceJoin = root.join(Product_.commerce);

            cq.select(
                    cb.construct(
                            ProductDto.class,
                            root.get(Product_.productId),
                            root.get(Product_.name),
                            root.get(Product_.description),
                            root.get(Product_.code),
                            root.get(Product_.price),
                            root.get(Product_.stock),
                            root.get(Product_.image),
                            commerceJoin.get(Commerce_.commerceId),
                            categoryJoin.get(Category_.categoryId)
                    )
            ).orderBy(
                    cb.asc(root.get(Product_.name))
            );
            result = em.createQuery(cq).getResultList();
            result.forEach(product -> {
                product.updateTaxes(taxService.getAllTaxesIdByProductId(product.getProductId()));
            });
        } catch (Exception ex) {
            log.error("Error en la criteria getAllProduct [{}]", ex.getMessage());
        }
        return result;
    }

    @Override
    public ProductDto getProductById(UUID uuid) {
        ProductDto result = null;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        try {
            CriteriaQuery<ProductDto> cq = cb.createQuery(ProductDto.class);
            Root<Product> root = cq.from(Product.class);
            Join<Product, Category> categoryJoin = root.join(Product_.category);
            Join<Product, Commerce> commerceJoin = root.join(Product_.commerce);

            cq.select(
                    cb.construct(
                            ProductDto.class,
                            root.get(Product_.productId),
                            root.get(Product_.name),
                            root.get(Product_.description),
                            root.get(Product_.code),
                            root.get(Product_.price),
                            root.get(Product_.stock),
                            root.get(Product_.image),
                            commerceJoin.get(Commerce_.commerceId),
                            categoryJoin.get(Category_.categoryId)
                    )
            ).where(
                    cb.equal(root.get(Product_.productId), uuid)
            ).orderBy(
                    cb.asc(root.get(Product_.name))
            );
            result = em.createQuery(cq).getSingleResult();
            result.updateTaxes(taxService.getAllTaxesIdByProductId(uuid));
        } catch (Exception ex) {
            log.error("Error en la criteria getProduct [{}]", ex.getMessage());
        }
        return result;
    }
}
