package com.base64.gamesback.commerce.product.entity;

import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.tax.entity.Tax;
import com.base64.gamesback.common.audit.AuditEntity;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.util.UUID;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ extends AuditEntity {

    public static volatile SingularAttribute<Product, UUID> productId;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Integer> code;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile SingularAttribute<Product, Integer> stock;
    public static volatile SingularAttribute<Product, String> image;
    public static volatile SingularAttribute<Product, Commerce> commerce;
    public static volatile SingularAttribute<Product, Category> category;
    public static volatile ListAttribute<Product, Tax> taxes;

}
