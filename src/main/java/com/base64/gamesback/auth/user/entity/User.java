package com.base64.gamesback.auth.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "main")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID userId;

    @OneToOne(mappedBy = "user")
    private Person person;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "administrator")
    private boolean administrator;

    @Column(name = "profile_image", columnDefinition = "TEXT")
    private String profileImage;

    public User(String userName, String password, boolean administrator, String profileImage) {
        this.userName = userName;
        this.password = password;
        this.administrator = administrator;
        this.profileImage = profileImage;
    }

    public User() {

    }

    public static User create( String userName, String password, boolean administrator, String profileImag){
        return new User(userName, password, administrator, profileImag);
    }

    public void update(String userName, String profileImage){
        this.userName = userName;
        this.profileImage = profileImage;
    }
}