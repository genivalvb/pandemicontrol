package com.pandemicontrol.pandemia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExameAlreadyRegisteredException extends Exception{

    public ExameAlreadyRegisteredException(String exameName){
        super(String.format("Exame with hasName %s already registered in the system", exameName));
    }
}
