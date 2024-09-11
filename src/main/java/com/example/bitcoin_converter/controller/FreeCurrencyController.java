package com.example.bitcoin_converter.controller;

import com.example.bitcoin_converter.dto.CurrencyDtoRequest;
import com.example.bitcoin_converter.dto.CurrencyDtoResponse;
import com.example.bitcoin_converter.service.FreeCurrencyIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/freeconvert")
public class FreeCurrencyController {
    private final FreeCurrencyIntegrationService integrationService;

    @GetMapping()
    public ResponseEntity<CurrencyDtoResponse> convert(@RequestBody CurrencyDtoRequest currencyDtoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(integrationService.transfer(currencyDtoRequest));
    }
}
