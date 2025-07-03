package com.base64.gamesback.commerce.product.entity;

import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "product", schema = "main")
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private Number code;

    @Column(name = "price")
    private Number price;

    @Column(name = "stock")
    private Number stock;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commerce_id", nullable = false)
    private Commerce commerce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product() {

    }

    public Product(String name, String description, Number code, Number price, Number stock, String image) {
        this.name = name;
        this.description = description;
        this.code = code;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.createAt = LocalDateTime.now();
    }

    public static Product  create(String name, String description, Number code, Number price, Number stock, String image){
        return new Product(name, description, code, price, stock, image);
    }

    public  void  update(String name, String description, Number code, Number price, Number stock, String image){
        this.name = name;
        this.description = description;
        this.code = code;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.updateAt = LocalDateTime.now();
    }

    public void addCategory(Category category){
        this.category = category;
    }

    public void addCommerce(Commerce commerce){
        this.commerce = commerce;
    }
}
