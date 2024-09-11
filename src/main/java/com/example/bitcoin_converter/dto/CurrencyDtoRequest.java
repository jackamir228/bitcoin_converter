package com.example.bitcoin_converter.dto;

import java.math.BigDecimal;

public record CurrencyDtoRequest(
        String transferCurrencyName,
        BigDecimal amountRub
) {

}
