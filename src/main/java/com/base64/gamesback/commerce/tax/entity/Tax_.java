package com.base64.gamesback.commerce.tax.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tax.class)
public abstract class Tax_ {

    public static volatile SingularAttribute<Tax, UUID> taxId;
    public static volatile SingularAttribute<Tax, String> name;
    public static volatile SingularAttribute<Tax, String> description;
}
