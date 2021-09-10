package com.pandemicontrol.pandemia.controller;

import com.pandemicontrol.pandemia.dto.PacienteDTO;
import com.pandemicontrol.pandemia.exception.PacienteAlreadyRegisteredException;
import com.pandemicontrol.pandemia.exception.PacienteNotFoundException;
import com.pandemicontrol.pandemia.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PacienteController implements PacienteControllerDocs{

    private final PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteDTO createPaciente(@RequestBody @Valid PacienteDTO pacienteDTO) throws PacienteAlreadyRegisteredException{
        return pacienteService.createPaciente(pacienteDTO);
    }

    @GetMapping("/{name}")
    public PacienteDTO findByNameHash(@PathVariable String nameHash) throws PacienteNotFoundException {
        return pacienteService.findByNameHash(nameHash);
    }

    @GetMapping
    public List<PacienteDTO> listPacientes() {
        return pacienteService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PacienteNotFoundException {
        pacienteService.deleteById(id);
    }
}
