package com.base64.gamesback.category.entity;

import com.base64.gamesback.product.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "category", schema = "main")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    public Category() {

    }

    public static Category create(String categoryName){
        return new Category(categoryName);
    }

}
