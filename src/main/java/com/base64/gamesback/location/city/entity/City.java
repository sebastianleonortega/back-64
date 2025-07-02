package com.base64.gamesback.location.city.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Entity
@Table(name = "city", schema = "main")
public class City {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "city_id", nullable = false)
    private UUID cityId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
