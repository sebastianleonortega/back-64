package com.base64.gamesback.auth.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class PersonDto {

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 50)
    @JsonProperty(value = "person_name")
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 50)
    @JsonProperty(value = "person_last_name")
    private String lastname;

    @NotNull
    @NotEmpty
    @Size(max = 50)
    @JsonProperty(value = "person_document")
    private String documentNumber;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 15)
    @JsonProperty(value = "person_phone")
    private String phone;

    @NotNull
    @Size(max = 50)
    @JsonProperty(value = "person_address")
    private String address;

    @NotNull
    @NotEmpty
    @Size(max = 50)
    @Email
    @JsonProperty(value = "person_email")
    private String email;

    public PersonDto(String name, String lastname, String documentNumber, String phone, String address, String email) {
        this.name = name;
        this.lastname = lastname;
        this.documentNumber = documentNumber;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }


}
