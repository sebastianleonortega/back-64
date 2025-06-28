package com.base64.gamesback.product.entity;

import com.base64.gamesback.category.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "product", schema = "main")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_qualification")
    private Number productQualification;

    @Column(name = "product_year")
    private String productYear;

    @Column(name = "product_image", columnDefinition = "TEXT")
    private String productImage;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String productName, String productDescription, Number productQualification, String productYear, String productImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQualification = productQualification;
        this.productYear = productYear;
        this.productImage = productImage;
    }

    public Product() {

    }

    public static Product  create(String productName, String productDescription, Number productQualification, String productYear, String productImage){
        return new Product(productName, productDescription, productQualification, productYear, productImage);
    }

    public  void  update(String productName, String productDescription, Number productQualification, String productYear, String productImage){
        this.productName = productName;
        this.productDescription = productDescription;
        this.productQualification = productQualification;
        this.productYear = productYear;
        this.productImage = productImage;
    }

    public void addCategory(Category category){
        this.category = category;
    }
}
