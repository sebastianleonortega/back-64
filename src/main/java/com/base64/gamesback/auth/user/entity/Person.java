package com.base64.gamesback.auth.user.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Data
@Entity
@Table(name = "person", schema = "main")
public class Person {

    @Id
    private UUID personId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "person_name", nullable = false, length = 100)
    private String personName;

    @Column(name = "person_last_name", nullable = false, length = 100)
    private String personLastName;

    @Column(name = "person_document", nullable = false, length = 15, unique = true)
    private String personDocument;

    @Column(name = "person_address", nullable = false, length = 50)
    private String personAddress;

    @Column(name = "person_phone", nullable = false, length = 13)
    private String personPhone;

    @Column(name = "person_email", nullable = false, length = 200, unique = true)
    private String personEmail;

    public Person() {

    }

    /** Constructor de la clase Person. **/
    public Person(String personName, String personLastName, String personDocument, String personAddress, String personPhone, String personEmail) {
        this.personName = personName;
        this.personLastName = personLastName;
        this.personDocument = personDocument;
        this.personAddress = personAddress;
        this.personPhone = personPhone;
        this.personEmail = personEmail;
    }

    public static Person create(String personName, String personLastName, String personDocument, String personAddress, String personPhone, String personEmail){
        return  new Person(personName,personLastName,personDocument,personAddress,personPhone, personEmail);
    }

    public void update(String personName, String personLastName, String personDocument, String personAddress, String personPhone, String personEmail){
        this.personName = personName;
        this.personLastName = personLastName;
        this.personDocument = personDocument;
        this.personAddress = personAddress;
        this.personPhone = personPhone;
        this.personEmail = personEmail;
    }

    public void  addUser(User user){
        this.user = user;
    }
}
