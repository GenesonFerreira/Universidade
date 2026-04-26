package com.portifolio.api.modules.aluno.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonPropertyOrder({
        "id",
        "nomeCompleto",
        "cpf",
        "email",
        "telefone",
        "dataNascimento"
})
public class AlunoResponseDTO {

    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String telefone;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String email;
}