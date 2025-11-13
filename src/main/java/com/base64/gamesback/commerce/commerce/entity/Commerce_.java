package com.base64.gamesback.commerce.commerce.entity;

import com.base64.gamesback.common.audit.AuditEntity;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Commerce.class)
public abstract class Commerce_ extends AuditEntity {

    public static volatile SingularAttribute<Commerce, UUID> commerceId;
    public static volatile SingularAttribute<Commerce, String> name;
    public static volatile SingularAttribute<Commerce, String> nit;
    public static volatile SingularAttribute<Commerce, String> address;
    public static volatile SingularAttribute<Commerce, String> email;
    public static volatile SingularAttribute<Commerce, String> phone;
    public static volatile SingularAttribute<Commerce, String> status;

}
