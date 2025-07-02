package com.base64.gamesback.billing.invoice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "invoice", schema = "main")
public class Invoice {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "invoice_id", nullable = false)
    private UUID invoiceId;

    @Column(name = "code")
    private String code;

    @Column(name = "total")
    private Number total;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;
}
