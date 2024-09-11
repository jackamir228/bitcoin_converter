package com.example.bitcoin_converter.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record CurrencyDtoResponse(
        String name,
        BigDecimal amount,
        BigDecimal rate,
        LocalDateTime time
) {
}
