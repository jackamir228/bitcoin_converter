package com.example.bitcoin_converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class BitcoinConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinConverterApplication.class, args);
    }

}
