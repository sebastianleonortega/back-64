package com.base64.gamesback.authorization.module.entity;

import com.base64.gamesback.authorization.permission.entity.Permission;
import com.base64.gamesback.common.audit.AuditEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Table(name = "module", schema = "main")
@Entity
public class Module extends AuditEntity {

    @Id
    @UuidGenerator
    @Column(name = "module_id")
    private UUID moduleId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @Column(name = "route")
    private String route;

    @Column(name = "module_order", nullable = false)
    private Integer order;

    @OneToMany(mappedBy = "module")
    private List<Permission> permissions;

    public Module() {}

    public Module(String name, String description, String icon, String route, Integer order, List<Permission> permissions) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.route = route;
        this.order = order;
        this.permissions = permissions;
    }

    public static Module create(String name, String description, String icon, String route, Integer order, List<Permission> permissions) {
        return new Module(name, description, icon, route, order, permissions);
    }
}
