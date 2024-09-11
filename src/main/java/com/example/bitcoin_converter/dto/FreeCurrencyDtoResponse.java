package com.example.bitcoin_converter.dto;

import java.math.BigDecimal;
import java.util.Map;

public record FreeCurrencyDtoResponse(
        Map<String, BigDecimal> data
) {
}
