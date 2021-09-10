package com.pandemicontrol.pandemia.mapper;

import com.pandemicontrol.pandemia.dto.PacienteDTO;
import com.pandemicontrol.pandemia.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PacienteMapper {

    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    Paciente toModel(PacienteDTO pacienteDTO);

    PacienteDTO toDTO(Paciente paciente);
}
