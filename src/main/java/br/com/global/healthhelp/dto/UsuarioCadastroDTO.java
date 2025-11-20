package br.com.global.healthhelp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCadastroDTO(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email

) { }
