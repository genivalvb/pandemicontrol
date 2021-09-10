package com.pandemicontrol.pandemia.service;

import com.pandemicontrol.pandemia.dto.ExameDTO;
import com.pandemicontrol.pandemia.entity.Exame;
import com.pandemicontrol.pandemia.entity.Paciente;
import com.pandemicontrol.pandemia.exception.ExameAlreadyRegisteredException;
import com.pandemicontrol.pandemia.exception.ExameNotFoundException;
import com.pandemicontrol.pandemia.mapper.ExameMapper;
import com.pandemicontrol.pandemia.mapper.PacienteMapper;
import com.pandemicontrol.pandemia.repository.ExameRepository;
import com.pandemicontrol.pandemia.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExameService {

    private final ExameRepository exameRepository;
    private final ExameMapper exameMapper = ExameMapper.INSTANCE;

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper = PacienteMapper.INSTANCE;

    public ExameDTO createExame(ExameDTO exameDTO) throws ExameAlreadyRegisteredException {
        verifyIfIsAlreadyRegistered(exameDTO.getAtendimentoHash());
        Exame exame = exameMapper.toModel(exameDTO);
        Exame savedExame = exameRepository.save(exame);
        return exameMapper.toDTO(savedExame);
    }

    public ExameDTO findByAtendimentoHash(String atendimentoHash) throws ExameNotFoundException {
        Exame foundExame = exameRepository.findByAtendimentoHash(atendimentoHash)
                .orElseThrow(() -> new ExameNotFoundException(atendimentoHash));
        return exameMapper.toDTO(foundExame);
    }

    //Retorna a lista completa dos exames
    public List<ExameDTO> listAll(){
        return exameRepository.findAll()
                .stream()
                .map(exameMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws ExameNotFoundException{
        verifyIfExists(id);
        exameRepository.deleteById(id);
    }

    public ExameDTO assignPacienteToExame(Long exameId, Long pacienteId) {
        Exame exame = exameRepository.findById(exameId).get();
        Paciente paciente = pacienteRepository.findById(pacienteId).get();
        exame.setPaciente(paciente);
        return exameMapper.toDTO(exameRepository.save(exame));
    }


    //Verificadores se existe e se não foi encontrado
    private void verifyIfIsAlreadyRegistered(String atendimentoHash) throws ExameAlreadyRegisteredException {
        Optional<Exame> optSavedExame = exameRepository.findByAtendimentoHash(atendimentoHash);
        if (optSavedExame.isPresent()) {
            throw new ExameAlreadyRegisteredException(atendimentoHash);
        }
    }

    private Exame verifyIfExists(Long id) throws ExameNotFoundException {
        return exameRepository.findById(id)
                .orElseThrow(() -> new ExameNotFoundException(id));
    }
}
