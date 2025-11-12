package com.base64.gamesback.commerce.category.entity;

import com.base64.gamesback.common.audit.AuditEntity;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ extends AuditEntity {

    public static volatile SingularAttribute<Category, UUID> categoryId;
    public static volatile SingularAttribute<Category, String> name;
}
