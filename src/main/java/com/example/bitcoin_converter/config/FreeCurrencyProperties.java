package com.example.bitcoin_converter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(value = "free-currency-integration")
@Configuration
public class FreeCurrencyProperties {
    private String baseUrl;
    private String token;
    private String headerTokenName;
}
