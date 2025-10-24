package com.base64.gamesback.commerce.product.entity;

import com.base64.gamesback.commerce.category.entity.Category;
import com.base64.gamesback.commerce.commerce.entity.Commerce;
import com.base64.gamesback.commerce.tax.entity.Tax;
import com.base64.gamesback.common.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "product", schema = "main")
public class Product extends AuditEntity {

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
    private Integer code;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commerce_id", nullable = false)
    private Commerce commerce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "product_tax", schema = "main",
            joinColumns = @JoinColumn(name = "product_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tax_id", nullable = false),
            uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "tax_id"}, name = "uc_product_tax")
    )
    private List<Tax> taxes;


    public Product() {

    }

    public Product(String name, String description, Integer code, BigDecimal price, Integer stock, String image) {
        this.name = name;
        this.description = description;
        this.code = code;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }

    public static Product  create(String name, String description, Integer code, BigDecimal price, Integer stock, String image){
        return new Product(name, description, code, price, stock, image);
    }

    public  void  update(String name, String description, Integer code, BigDecimal price, Integer stock, String image){
        this.name = name;
        this.description = description;
        this.code = code;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }

    public void addCategory(Category category){
        this.category = category;
    }

    public void addCommerce(Commerce commerce){
        this.commerce = commerce;
    }

    public void addTax(List<Tax> taxes){
        this.taxes = taxes;
    }
}
