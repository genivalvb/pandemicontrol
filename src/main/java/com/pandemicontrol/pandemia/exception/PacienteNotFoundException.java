package com.pandemicontrol.pandemia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PacienteNotFoundException extends Exception{
    public PacienteNotFoundException(String pacienteName){
        super(String.format("Paciente with hashName %s not found in the system", pacienteName));
    }

    public PacienteNotFoundException(Long id){
        super(String.format("Paciente with ID %s not found in the system", id));
    }
}
