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

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "document_number", nullable = false, length = 15, unique = true)
    private String documentNumber;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "phone", nullable = false, length = 13)
    private String phone;

    @Column(name = "email", nullable = false, length = 200, unique = true)
    private String email;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Person() {}

    /** Constructor de la clase Person. **/
    public Person(String firstName, String lastName, String documentNumber, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public static Person create(String firstName, String lastName, String documentNumber, String address, String phone, String email){
        return  new Person(firstName,lastName,documentNumber,address, phone, email);
    }

    public void update(String firstName, String lastName, String documentNumber, String address, String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public void  addUser(User user){
        this.user = user;
    }
}
