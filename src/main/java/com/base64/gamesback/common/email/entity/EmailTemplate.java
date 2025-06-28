package com.base64.gamesback.common.email.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "email_template", schema = "main")
public class EmailTemplate {

    @Id
    @Column(name = "name", unique = true, length = 100)
    private String name;

    @Column(name = "body", columnDefinition = "text")
    private String body;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public void replaceBody(String body){
        this.body = body;
    }

}
