package com.base64.gamesback.commerce.commerce.entity;

import com.base64.gamesback.commerce.product.entity.Product;
import com.base64.gamesback.common.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Table(name = "commerce", schema = "main")
@Entity
public class Commerce extends AuditEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "commerce_id", nullable = false)
    private UUID commerceId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "nit")
    private String nit;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "commerce")
    private List<Product> products;

    public Commerce() {}

    public Commerce(String name, String nit, String address, String email, String phone, String status) {
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public static Commerce create(String name, String nit, String address, String email, String phone, String status) {
        return new Commerce(name, nit, address, email, phone, status);
    }

    public void update(String name, String nit, String address, String email, String phone, String status) {
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public void updateStatus(String status){
        this.status = status;
    }
}
