package com.base64.gamesback.commerce.commerce.entity;

import com.base64.gamesback.commerce.product.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Table(name = "commerce", schema = "main")
@Entity
public class Commerce {

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

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "commerce")
    private List<Product> products;

    public Commerce() {
    }

    public Commerce(String name, String nit, String address, String email, String phone) {
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.createAt = LocalDateTime.now();
    }

    public static Commerce create(String name, String nit, String address, String email, String phone) {
        return new Commerce(name, nit, address, email, phone);
    }
}
