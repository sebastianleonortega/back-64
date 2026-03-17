package com.base64.gamesback.authorization.role.entity;

import com.base64.gamesback.user.entity.User;
import com.base64.gamesback.authorization.permission.entity.Permission;
import com.base64.gamesback.common.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Table(name = "role", schema = "main")
@Entity
public class Role extends AuditEntity {

    @Id
    @UuidGenerator
    @Column(name = "role_id")
    private UUID roleId;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @JoinTable(
            name = "role_permission", schema = "main",
            joinColumns = @JoinColumn(name = "role_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "permission_id",  nullable = false),
            uniqueConstraints = @UniqueConstraint(columnNames = {"role_id", "permission_id"}, name = "uc_role_permission")
    )
    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Permission> permissions;

    @ManyToMany(mappedBy = "roles")
    private List<User> user;

    public Role() {}

    public Role(String name) {
        this.name = name;
        this.isActive = true;
    }

    public static Role create(String name){
        return new Role(name);
    }

    public void addPermission(List<Permission> permission){
        this.permissions = permission;
    }
}
