package com.example.bitcoin_converter.model.currency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractCurrency {
    protected String code;
    protected String symbol;
    protected BigDecimal rate;
    protected String description;
    protected double rate_float;
}
