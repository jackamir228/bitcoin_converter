package com.example.bitcoin_converter.service;

import com.example.bitcoin_converter.model.CurrencyPojo;
import com.example.bitcoin_converter.repository.BitcoinRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@RequiredArgsConstructor
@Service
@Slf4j
public class CurrencyManagementService {
    private final BitcoinRepository bitcoinRepository;

    public List<CurrencyPojo> findALl() {
        return bitcoinRepository.findAll();
    }

    public void save(CurrencyPojo currencyPojo) {
        bitcoinRepository.save(currencyPojo);
    }

    public double getAverageAmountBitcoin() {
        ArrayList<CurrencyPojo> allCurrencies = bitcoinRepository.findAll();

        if (allCurrencies.isEmpty()) {
            throw new RuntimeException("No rates now!");
        }

        double averageValues = allCurrencies.stream()
                .mapToDouble(e -> e.getAmount().doubleValue())
                .average()
                .orElseThrow();
        log.info("среднее арифметическое равно {}", averageValues);
        return averageValues;
    }
}
