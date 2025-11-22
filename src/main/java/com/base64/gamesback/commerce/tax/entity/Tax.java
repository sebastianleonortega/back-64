package com.base64.gamesback.commerce.tax.entity;

import com.base64.gamesback.commerce.product.entity.Product;
import com.base64.gamesback.common.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "tax", schema = "main")
public class Tax extends AuditEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "tax_id", nullable = false)
    private UUID taxId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "taxes")
    private List<Product> products;

    public Tax() {}

    public Tax(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Tax create(String name, String description) {
        return new Tax(name, description);
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
