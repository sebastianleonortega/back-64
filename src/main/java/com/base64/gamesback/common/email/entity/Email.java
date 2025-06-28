package com.base64.gamesback.common.email.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "email", schema ="main")
public class Email {

    @Id
    @GenericGenerator(name = "uuid" )
    @Column(name = "email_id", nullable = false)
    private UUID emailId;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "copy", length = 500)
    private String copy;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "body", columnDefinition = "text")
    private String body;

    @Column(name = "sent")
    private Boolean sent;

    @Column(name = "error", columnDefinition = "text")
    private String error;

    @Column(name = "attached", columnDefinition = "text")
    private String attached;

    @Column(name = "attached_name", length = 200)
    private String attachedName;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Email() {
    }

    public Email(String destination, String copy, String subject, String body) {
        this.destination = destination;
        this.copy = copy;
        this.subject = subject;
        this.body = body;
    }

    public static Email create(String destination, String copy, String subject, String body) {
        return new Email(destination, copy, subject, body);
    }

    public void addStatus(Boolean sent, String error) {
        this.sent = sent;
        this.error = error;
    }

    public void addAttachedDocument(String attachedName, String attached) {
        this.attached = attached;
        this.attachedName = attachedName;
    }

}
