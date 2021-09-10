package com.pandemicontrol.pandemia.controller;

import com.pandemicontrol.pandemia.dto.ExameDTO;
import com.pandemicontrol.pandemia.dto.PacienteDTO;
import com.pandemicontrol.pandemia.entity.Paciente;
import com.pandemicontrol.pandemia.exception.ExameAlreadyRegisteredException;
import com.pandemicontrol.pandemia.exception.ExameNotFoundException;
import com.pandemicontrol.pandemia.exception.PacienteNotFoundException;
import com.pandemicontrol.pandemia.service.ExameService;
import com.pandemicontrol.pandemia.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exames")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExameController implements ExameControllerDocs{

    private final ExameService exameService;
    private final PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExameDTO createExame(@RequestBody @Valid ExameDTO exameDTO) throws ExameAlreadyRegisteredException {
        return exameService.createExame(exameDTO);
    }

    @GetMapping("/{atendimento}")
    public ExameDTO findByAtendimentoHash(@PathVariable String atendimentoHash) throws ExameNotFoundException {
        return exameService.findByAtendimentoHash(atendimentoHash);
    }

    @GetMapping
    public List<ExameDTO> listExames() {
        return exameService.listAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ExameNotFoundException {
        exameService.deleteById(id);
    }

    @PutMapping("/{exameId}/pacientes/{pacienteId}")
    public ExameDTO assignPacienteToExame(@PathVariable Long exameId, @PathVariable Long pacienteId){
        return exameService.assignPacienteToExame(exameId,pacienteId);

    }
}
