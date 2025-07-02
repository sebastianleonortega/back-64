package com.base64.gamesback.auth.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
public class PersonUpdateRequest {

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 40)
    @JsonProperty(value = "first_name")
    private String firstName;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 40)
    @JsonProperty(value = "last_name")
    private String lastName;

    @NotEmpty
    @NotNull
    @Size(max = 50)
    @JsonProperty(value = "document_number")
    private String documentNumber;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 50)
    @JsonProperty(value = "address")
    private String address;

    @NotEmpty
    @NotNull
    @Size(min = 8, max = 15)
    @JsonProperty(value = "phone")
    private String phone;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 100)
    @JsonProperty(value = "email")
    private String email;
}
