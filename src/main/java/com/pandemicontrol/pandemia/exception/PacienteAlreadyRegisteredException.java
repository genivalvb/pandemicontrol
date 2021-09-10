package com.pandemicontrol.pandemia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PacienteAlreadyRegisteredException extends Exception{

    public PacienteAlreadyRegisteredException(String pacienteName){
        super(String.format("Paciente with hasName %s already registered in the system", pacienteName));
    }
}
