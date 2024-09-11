package com.example.bitcoin_converter.model.currency;

import java.math.BigDecimal;

public class RUB extends AbstractCurrency {
    public RUB(String code, String symbol, BigDecimal rate, String description, double rate_float) {
        super(code, symbol, rate, description, rate_float);
    }
}
