package com.base64.gamesback.auth.role.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Table(name = "role", schema = "main")
@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(name = "role_id", nullable = false)
    private UUID roleId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

}
