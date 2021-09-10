package com.pandemicontrol.pandemia.controller;

import com.pandemicontrol.pandemia.dto.ExameDTO;
import com.pandemicontrol.pandemia.exception.ExameAlreadyRegisteredException;
import com.pandemicontrol.pandemia.exception.ExameNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Manages exame content")
public interface ExameControllerDocs {

    @ApiOperation(value = "Exame creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success exame creation"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value.")
    })
    ExameDTO createExame(ExameDTO exameDTO) throws ExameAlreadyRegisteredException;

    @ApiOperation(value = "Returns exame found by a given name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success exame found in the system"),
            @ApiResponse(code = 404, message = "Exame with given name not found.")
    })
    ExameDTO findByAtendimentoHash(@PathVariable String atendimentoHash) throws ExameNotFoundException;

    @ApiOperation(value = "Returns a list of all exames registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all exames registered in the system"),
    })
    List<ExameDTO> listExames();

    @ApiOperation(value = "Delete a exame found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success exame deleted in the system"),
            @ApiResponse(code = 404, message = "Exame with given id not found.")
    })
    void deleteById(@PathVariable Long id) throws ExameNotFoundException;
}
