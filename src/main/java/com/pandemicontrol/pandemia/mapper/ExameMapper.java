package com.pandemicontrol.pandemia.mapper;

import com.pandemicontrol.pandemia.dto.ExameDTO;
import com.pandemicontrol.pandemia.dto.PacienteDTO;
import com.pandemicontrol.pandemia.entity.Exame;
import com.pandemicontrol.pandemia.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExameMapper {

    ExameMapper INSTANCE = Mappers.getMapper(ExameMapper.class);

    Exame toModel(ExameDTO exameDTO);

    ExameDTO toDTO(Exame exame);
}
