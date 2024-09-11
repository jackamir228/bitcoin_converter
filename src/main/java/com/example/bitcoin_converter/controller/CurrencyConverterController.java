package com.example.bitcoin_converter.controller;

import com.example.bitcoin_converter.dto.CurrencyDtoRequest;
import com.example.bitcoin_converter.dto.CurrencyDtoResponse;
import com.example.bitcoin_converter.model.CurrencyPojo;
import com.example.bitcoin_converter.service.CurrencyConverterService;
import com.example.bitcoin_converter.service.CurrencyManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyConverterController {
    private final CurrencyConverterService currencyConverterService;
    private final CurrencyManagementService managementService;

    @PostMapping("/convert")
    public ResponseEntity<CurrencyDtoResponse> convertCurrency(@RequestBody CurrencyDtoRequest dtoRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(currencyConverterService.convertRubToBitcoin(dtoRequest));
    }

    @GetMapping("/history")
    public ResponseEntity<List<CurrencyPojo>> getAllRequests() {
        return ResponseEntity.status(HttpStatus.OK).body(managementService.findALl());
    }

    @GetMapping("/average")
    public ResponseEntity<Double> getAverageAmountBitcoin() {
        return ResponseEntity.status(HttpStatus.OK).body(managementService.getAverageAmountBitcoin());
    }
}
