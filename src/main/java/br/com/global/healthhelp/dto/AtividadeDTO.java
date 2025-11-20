package br.com.global.healthhelp.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AtividadeDTO(

        Long id,

        @NotNull
        Long idCategoria,

        @NotNull
        LocalDateTime inicio,

        @NotNull
        LocalDateTime fim,

        String descricao

) { }
