package com.base64.gamesback.auth.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UpdatePassword {


    @NotBlank(message = "La contraseña es requerida")
    private String password;

    @NotBlank(message = "La confirmación de la contraseña es requerida")
    private String confirmPassword;
}
