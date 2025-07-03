package com.base64.gamesback.commerce.category.entity;

import com.base64.gamesback.commerce.product.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "category", schema = "main")
public class Category {

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String name){
        this.name = name;
    }

    public Category() {

    }

    public static Category create(String name){
        return new Category(name);
    }

}
