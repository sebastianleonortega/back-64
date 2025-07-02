package com.base64.gamesback.auth.user.dto;

import com.base64.gamesback.common.exception_handler.validation.anotation.UserName;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserDto {

    @NotNull
    @UserName
    @JsonProperty(value = "name")
    private String name;

    @NotNull
    @JsonProperty(value = "password")
    private String password;

    @Valid
    @JsonProperty(value = "person")
    private PersonDto person;

    public UserDto(String name,String password, PersonDto person) {
        this.name = name;
        this.password = password;
        this.person = person;
    }
}
