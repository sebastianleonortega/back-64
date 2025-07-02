package com.base64.gamesback.billing.invoice_item.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "invoice_item", schema = "main")
public class InvoiceItem {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "invoice_item_id", nullable = false)
    private UUID invoiceItemId;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Number quantity;

    @Column(name = "unit_price")
    private Number unitPrice;

    @Column(name = "subtotal")
    private Number subtotal;

    @Column(name = "tax_amount_total")
    private Number taxAmountTotal;

    @Column(name = "total_with_tax")
    private Number totalWithTax;

    @Column(name = "total_price")
    private Number totalPrice;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

}
