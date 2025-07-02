package com.base64.gamesback.billing.payment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "payment", schema = "main")
public class Payment {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "payment_id", nullable = false)
    private UUID paymentId;

    @Column(name = "status")
    private String status;

    @Column(name = "method")
    private String method;

    @Column(name = "reference")
    private String reference;

    @Column(name = "amount")
    private Number amount;

    @Column(name = "create_at")
    private LocalDateTime createAt;


}
