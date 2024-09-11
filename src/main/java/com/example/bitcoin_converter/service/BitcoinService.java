package com.example.bitcoin_converter.service;

import com.example.bitcoin_converter.config.CoinDeskProperties;
import com.example.bitcoin_converter.dto.coindesk.USDDtoResponse;
import com.example.bitcoin_converter.exception.BitcoinIntegrationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service

public class BitcoinService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final CoinDeskProperties properties;
    private final ObjectMapper objectMapper;

    /**
     * В данном методе мы получаем курс биткоина относительно к доллару
     */
    public USDDtoResponse getBitcoinRate() {
        //делаем запрос на получения json
        RequestEntity<Void> request = RequestEntity
                .get(properties.getJsonUrl())
                .build();
        ResponseEntity<String> responseEntity;
        try {
            //записываем json как стрингу
            responseEntity = restTemplate.exchange(request, String.class);
            JsonNode jsonNode = objectMapper.readTree(responseEntity.getBody());

            //парсим json который пришел с сайта
            JsonNode dollarNode = jsonNode.path("bpi").path("USD");

            String rateString = dollarNode.path("rate").asText().replace(",", "");
            BigDecimal dollarRate = new BigDecimal(rateString);

            String code = dollarNode.path("code").asText();
            String symbol = dollarNode.path("symbol").asText();
            String description = dollarNode.path("description").asText();
            double rateFloat = dollarNode.path("rate_float").asDouble();

            return USDDtoResponse.builder()
                    .code(code)
                    .symbol(symbol)
                    .rate(dollarRate)
                    .description(description)
                    .rate_float(rateFloat)
                    .build();
        } catch (BitcoinIntegrationException | JsonProcessingException e) {
            throw new BitcoinIntegrationException();
        }
    }
}
