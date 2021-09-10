package com.pandemicontrol.pandemia.dto;

import com.pandemicontrol.pandemia.entity.Exame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private Long id;
    @NotNull
    private String nameHash;
    @NotNull
    private String sexo;
    @NotNull
    private Integer anoNascimento;
    @NotNull
    private String cidade;
    @NotNull
    private String uf;
    @NotNull
    private String pais;

    private List<Exame> exames;
}
