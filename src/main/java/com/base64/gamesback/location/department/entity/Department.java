package com.base64.gamesback.location.department.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Entity
@Table(name = "department", schema = "main")
public class Department {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "department_id", nullable = false)
    private UUID departmentId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
