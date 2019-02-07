package com.projet.gpl.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException
{
    public MyFileNotFoundException(final String message) {
        super(message);
    }
    
    public MyFileNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
