package com.example.bitcoin_converter.service;

import com.example.bitcoin_converter.config.FreeCurrencyProperties;
import com.example.bitcoin_converter.dto.CurrencyDtoRequest;
import com.example.bitcoin_converter.dto.CurrencyDtoResponse;
import com.example.bitcoin_converter.model.CurrencyPojo;
import com.example.bitcoin_converter.repository.BitcoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CurrencyConverterService {
    private final FreeCurrencyProperties properties;
    private final BitcoinService bitcoinService;
    private final FreeCurrencyIntegrationService freeCurrencyService;
    private final BitcoinRepository bitcoinRepository;
    private final CurrencyManagementService managementService;

    public CurrencyDtoResponse convertRubToBitcoin(CurrencyDtoRequest dtoRequest) {
        BigDecimal bitcoinAmount = bitcoinService.getBitcoinRate().rate();
        CurrencyDtoResponse dollars = freeCurrencyService.transfer(dtoRequest);
        BigDecimal bitcoinRate = dollars.amount().divide(bitcoinAmount, 2, RoundingMode.CEILING);

        CurrencyDtoResponse dtoResponse = CurrencyDtoResponse.builder()
                .name(dtoRequest.transferCurrencyName())
                .amount(bitcoinAmount)
                .rate(bitcoinRate)
                .time(LocalDateTime.now())
                .build();

        managementService.save(convertResponseToEntity(dtoResponse));
        return dtoResponse;
    }

    private CurrencyPojo convertResponseToEntity(CurrencyDtoResponse dto) {
        return new CurrencyPojo(dto.name(), dto.amount(), dto.rate(), dto.time());
    }
}
