package com.example.bitcoin_converter.controller;

import com.example.bitcoin_converter.exception.BitcoinIntegrationException;
import com.example.bitcoin_converter.exception.FreeCurrencyIntegrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BitcoinControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> serverHandlerException() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("На сайте наблюдаются проблемы, приходите позже");
    }

    @ExceptionHandler(BitcoinIntegrationException.class)
    public ResponseEntity<String> bitcoinIntegrationHandlerException() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body( "Ошибка во внешнем сервисе получения в получении курса биткоина");
    }

    @ExceptionHandler(FreeCurrencyIntegrationException.class)
    public ResponseEntity<String> freeCurrencyIntegrationHandlerException() {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body( "Ошибка во внешнем сервисе получения получении доллара");
    }
}
