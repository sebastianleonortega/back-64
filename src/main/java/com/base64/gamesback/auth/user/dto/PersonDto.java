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
    @JsonProperty(value = "first_name")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 50)
    @JsonProperty(value = "last_name")
    private String lastname;

    @NotNull
    @NotEmpty
    @Size(max = 50)
    @JsonProperty(value = "document_number")
    private String documentNumber;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 15)
    @JsonProperty(value = "phone")
    private String phone;

    @NotNull
    @Size(max = 50)
    @JsonProperty(value = "address")
    private String address;

    @NotNull
    @NotEmpty
    @Size(max = 50)
    @Email
    @JsonProperty(value = "email")
    private String email;

    public PersonDto(String firstName, String lastName, String documentNumber, String phone, String address, String email) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.documentNumber = documentNumber;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }


}
