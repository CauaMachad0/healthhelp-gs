package br.com.global.healthhelp.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public record RegistroDiarioDTO(

        Long id,

        @NotNull
        LocalDate dataRegistro,

        Integer pontuacaoEquilibrio,

        String observacoes,

        @NotNull
        List<AtividadeDTO> atividades

) { }
