package com.trabalhoundb.manage.checkers.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCredentialsDTO(
        @NotBlank(message = "campo vazio")
        @Email(message = "email inválido")
        @Size(max = 80, message = "email muito grande")
        String email,

        @NotBlank(message = "campo vazio")
        String password
) {
}
