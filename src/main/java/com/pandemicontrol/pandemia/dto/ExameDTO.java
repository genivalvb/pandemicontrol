package com.pandemicontrol.pandemia.dto;

import com.pandemicontrol.pandemia.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExameDTO {

    private Long id;

    @NotNull
    private String pacienteHash;

    @NotNull
    private String atendimentoHash;

    @NotNull
    private String dtColeta;

    @NotNull
    private String deOrigem;

    @NotNull
    private String deExame;

    @NotNull
    private String deAnalito;

    @NotNull
    private String deResultado;

    @NotNull
    private String cdUnidade;

    @NotNull
    private String deValorReferencia;

    private Paciente paciente;
}
