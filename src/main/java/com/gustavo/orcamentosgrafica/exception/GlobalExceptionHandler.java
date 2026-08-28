package com.gustavo.orcamentosgrafica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArquivoInvalidoException.class)
    public ResponseEntity<Map<String, String>> tratarArquivoInvalido(ArquivoInvalidoException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("erro", exception.getMessage()));
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Map<String, String>> tratarArquivoMuitoGrande(MaxUploadSizeExceededException exception){
        return ResponseEntity.status(HttpStatus.CONTENT_TOO_LARGE).body(Map.of("erro", "A arte deve ter no máximo 10MB!"));
    }

}
