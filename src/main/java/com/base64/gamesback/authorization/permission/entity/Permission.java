package com.base64.gamesback.authorization.permission.entity;

import com.base64.gamesback.authorization.module.entity.Module;
import com.base64.gamesback.authorization.role.entity.Role;
import com.base64.gamesback.common.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Table(name = "permission", schema = "main")
@Entity
public class Permission extends AuditEntity {

    @Id
    @UuidGenerator
    @Column(name = "permission_id")
    private UUID permissionId;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Transient
    private Boolean checked;

    @ManyToMany(mappedBy = "permissions")
    @Fetch(FetchMode.SUBSELECT)
    private List<Role> roles;

    @Column(name = "module_id", nullable = false)
    private UUID moduleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false, insertable = false, updatable = false)
    private Module module;

    public Permission() {}

    public Permission(String name, String title, Module module) {
        this.name = name;
        this.title = title;
        this.module = module;
    }

    public void thisChecked(Boolean checked) {
        this.checked = checked;
    }

}
