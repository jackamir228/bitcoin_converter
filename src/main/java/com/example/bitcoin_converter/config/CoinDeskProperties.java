package com.example.bitcoin_converter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "coin-desk-integration")
public class CoinDeskProperties {
    private String jsonUrl;
}
