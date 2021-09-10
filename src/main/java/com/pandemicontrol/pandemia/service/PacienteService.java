package com.pandemicontrol.pandemia.service;

import com.pandemicontrol.pandemia.dto.ExameDTO;
import com.pandemicontrol.pandemia.dto.PacienteDTO;
import com.pandemicontrol.pandemia.entity.Exame;
import com.pandemicontrol.pandemia.entity.Paciente;
import com.pandemicontrol.pandemia.exception.PacienteAlreadyRegisteredException;
import com.pandemicontrol.pandemia.exception.PacienteNotFoundException;
import com.pandemicontrol.pandemia.mapper.ExameMapper;
import com.pandemicontrol.pandemia.mapper.PacienteMapper;
import com.pandemicontrol.pandemia.repository.ExameRepository;
import com.pandemicontrol.pandemia.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper = PacienteMapper.INSTANCE;


    public PacienteDTO createPaciente(PacienteDTO pacienteDTO) throws PacienteAlreadyRegisteredException{
        verifyIfIsAlreadyRegistered(pacienteDTO.getNameHash());
        Paciente paciente = pacienteMapper.toModel(pacienteDTO);
        Paciente savedPaciente = pacienteRepository.save(paciente);
        return pacienteMapper.toDTO(savedPaciente);
    }

    public PacienteDTO findByNameHash(String nameHash) throws PacienteNotFoundException{
        Paciente foundPaciente = pacienteRepository.findByNameHash(nameHash)
                .orElseThrow(() -> new PacienteNotFoundException(nameHash));
        return pacienteMapper.toDTO(foundPaciente);
    }

    //Retorna a lista completa dos pacientes
    public List<PacienteDTO> listAll(){
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PacienteDTO findById(Long id) throws PacienteNotFoundException{
        Paciente foundPaciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));
        return pacienteMapper.toDTO(foundPaciente);
    }

    public void deleteById(Long id) throws PacienteNotFoundException{
        verifyIfExists(id);
        pacienteRepository.deleteById(id);
    }


    //Verificadores se existe e se não foi encontrado
    private void verifyIfIsAlreadyRegistered(String nameHash) throws PacienteAlreadyRegisteredException {
        Optional<Paciente> optSavedPaciente = pacienteRepository.findByNameHash(nameHash);
        if (optSavedPaciente.isPresent()) {
            throw new PacienteAlreadyRegisteredException(nameHash);
        }
    }

    private Paciente verifyIfExists(Long id) throws PacienteNotFoundException {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));
    }
}
