package com.base64.gamesback.location.country.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Entity
@Table(name = "country", schema = "main")
public class Country {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "country_id", nullable = false)
    private UUID countryId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
}
