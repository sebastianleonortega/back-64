package com.base64.gamesback.user.entity;

import com.base64.gamesback.authorization.role.entity.Role;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "user", schema = "main")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @UuidGenerator
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "administrator")
    private boolean administrator;

    @Column(name = "profile_image", columnDefinition = "TEXT")
    private String profileImage;

    @Column(name = "code_verification", length = 6)
    private String codeVerification;

    @Column(name = "code_verification_created_at")
    private LocalDateTime codeVerificationCreatedAt;

    @Column(name = "mfa_is_email")
    private boolean mfaIsEmail;

    @OneToOne(mappedBy = "user")
    private Person person;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "user_role", schema = "main",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false),
            uniqueConstraints = @UniqueConstraint(name = "uc_user_role", columnNames = {"user_id", "role_id"})
    )
    private List<Role> roles;

    public User() {}

    public User(String name, String password, boolean administrator, String profileImage) {
        this.name = name;
        this.password = password;
        this.administrator = administrator;
        this.profileImage = profileImage;
    }

    public static User create( String name, String password, boolean administrator, String profileImag){
        return new User(name, password, administrator, profileImag);
    }

    public void update(String name, String profileImage){
        this.name = name;
        this.profileImage = profileImage;
    }

    public void addCodeVerification(String code) {
        this.codeVerification = code;
        this.codeVerificationCreatedAt = LocalDateTime.now();
    }

    public void addRole(List<Role> roles) {
        this.roles = roles;
    }
}