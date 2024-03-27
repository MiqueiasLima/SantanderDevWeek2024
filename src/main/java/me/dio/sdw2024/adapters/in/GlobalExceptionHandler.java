package me.dio.sdw2024.adapters.in;

import me.dio.sdw2024.domain.exception.ChampionNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    LoggerFactory.
    @ExceptionHandler(ChampionNotFoundException.class)
    public ResponseEntity<ApiError> handleDomainException(ChampionNotFoundException domainError){
        return ResponseEntity.unprocessableEntity().body(
                new ApiError(domainError.getMessage())
        );
    }

    @ExceptionHandler(ChampionNotFoundException.class)
    public ResponseEntity<ApiError> handleDomainException(Exception domainError){
        return ResponseEntity.internalServerError().body(
                new ApiError("Ops! Ocorreu um erro Inesperado")
        );
    }


    public record ApiError(String message){

    }
}
