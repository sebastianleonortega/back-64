package com.base64.gamesback.auth.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonUpdateRequest {

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 40)
    @JsonProperty(value = "person_name")
    private String personName;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 40)
    @JsonProperty(value = "person_last_name")
    private String personLastName;

    @NotEmpty
    @NotNull
    @Size(max = 50)
    @JsonProperty(value = "person_document")
    private String personDocument;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 50)
    @JsonProperty(value = "person_address")
    private String personAddress;

    @NotEmpty
    @NotNull
    @Size(min = 8, max = 15)
    @JsonProperty(value = "person_phone")
    private String personPhone;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 100)
    @JsonProperty(value = "person_email")
    private String personEmail;
}
