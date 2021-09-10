package com.pandemicontrol.pandemia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExameNotFoundException extends Exception{
    public ExameNotFoundException(String exameName){
        super(String.format("Exame with hashName %s not found in the system", exameName));
    }

    public ExameNotFoundException(Long id){
        super(String.format("Exame with ID %s not found in the system", id));
    }
}
