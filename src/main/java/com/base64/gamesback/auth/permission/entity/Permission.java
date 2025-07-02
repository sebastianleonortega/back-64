package com.base64.gamesback.auth.permission.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Table(name = "permission", schema = "main")
@Entity
public class Permission {

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(name = "permission_id", nullable = false)
    private UUID permissionId;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

}
