package com.base64.gamesback.commerce.product.repository;

import com.base64.gamesback.commerce.product.dto.projection.ProductProjection;
import com.base64.gamesback.commerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>, ProductRepositoryCustom {

    @Query("SELECT p.name AS name, description AS description, p.code AS code, p.price AS price, p.stock AS stock," +
            " p.image AS image, p.category.categoryId AS categoryId, p.commerce.commerceId AS commerceId from Product p")
    List<ProductProjection> getAllProductDto();


}
