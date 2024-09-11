package com.example.bitcoin_converter.repository;

import com.example.bitcoin_converter.model.CurrencyPojo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BitcoinRepository {
    private List<CurrencyPojo> currencies = new ArrayList<>();

    public void save(CurrencyPojo currency) {
        currencies.add(currency);
    }

    public ArrayList<CurrencyPojo> findAll() {
        return new ArrayList<>(currencies);
    }
}
