package com.example.bitcoin_converter.dto.coindesk;

import lombok.Builder;

import java.math.BigDecimal;


@Builder
public record USDDtoResponse(
        String code,
        String symbol,
        BigDecimal rate,
        String description,
        double rate_float
) {

}
