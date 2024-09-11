package com.example.bitcoin_converter.controller;

import com.example.bitcoin_converter.service.BitcoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rate")
public class CurrencyBitcoinController {
    private final BitcoinService bitcoinService;

    @GetMapping("/now")
    public ResponseEntity<?> convertBitcoinToRuble() {
        return ResponseEntity.status(HttpStatus.OK).body(bitcoinService.getBitcoinRate());
    }
}
