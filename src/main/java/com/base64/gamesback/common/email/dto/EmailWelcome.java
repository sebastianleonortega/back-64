package com.base64.gamesback.common.email.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class EmailWelcome {

    @NotBlank(message = "El nombre es requerido")
    private String recipientName;

    @NotBlank(message = "El mensage es requerido")
    @Email(message = "Formato de correo inválido")
    private String email;

}
