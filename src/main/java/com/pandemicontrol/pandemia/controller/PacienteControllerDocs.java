package com.pandemicontrol.pandemia.controller;

import com.pandemicontrol.pandemia.dto.PacienteDTO;
import com.pandemicontrol.pandemia.exception.PacienteAlreadyRegisteredException;
import com.pandemicontrol.pandemia.exception.PacienteNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages paciente content")
public interface PacienteControllerDocs {

    @ApiOperation(value = "Paciente creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success paciente creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    PacienteDTO createPaciente(PacienteDTO pacienteDTO) throws PacienteAlreadyRegisteredException;

    @ApiOperation(value = "Returns paciente found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success paciente found in the system"),
            @ApiResponse(code = 404, message = "Paciente with given name not found.")
    })
    PacienteDTO findByNameHash(@PathVariable String nameHash) throws PacienteNotFoundException;

    @ApiOperation(value = "Returns a list of all pacientes registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all pacientes registered in the system"),
    })
    List<PacienteDTO> listPacientes();

    @ApiOperation(value = "Delete a paciente found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success paciente deleted in the system"),
            @ApiResponse(code = 404, message = "Paciente with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws PacienteNotFoundException;
}
