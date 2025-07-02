package com.base64.gamesback.auth.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserUpdateRequest {

    @NotBlank
    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "profile_image")
    private String profileImage;

    @Valid
    @JsonProperty(value = "person")
    private PersonUpdateRequest person;
}
