package com.base64.gamesback.commerce.tax.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "tax", schema = "main")
public class Tax {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "tax_id", nullable = false)
    private UUID taxId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;
}
