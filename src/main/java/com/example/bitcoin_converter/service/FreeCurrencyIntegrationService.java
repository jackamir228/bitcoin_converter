package com.example.bitcoin_converter.service;

import com.example.bitcoin_converter.config.FreeCurrencyProperties;
import com.example.bitcoin_converter.dto.CurrencyDtoRequest;
import com.example.bitcoin_converter.dto.CurrencyDtoResponse;
import com.example.bitcoin_converter.dto.FreeCurrencyDtoResponse;
import com.example.bitcoin_converter.exception.FreeCurrencyIntegrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FreeCurrencyIntegrationService {
    private final FreeCurrencyProperties properties;
    private final RestTemplate restTemplate;
    private final static String TO_CONVERT_CURRENCY_NAME = "USD";
    private final static String BEING_CONVERT_CURRENCY_NAME = "RUB";
    private final static String POSTFIX_URL_TEMPLATE = "v1/latest?base_currency=%s&currencies=%s"
            .formatted(TO_CONVERT_CURRENCY_NAME, BEING_CONVERT_CURRENCY_NAME);

    /**
     * В данном методе мы конвертируем рубли в доллары
     */
    public CurrencyDtoResponse transfer(CurrencyDtoRequest dtoRequest) {
        RequestEntity<Void> request = RequestEntity
                .get("https://api.freecurrencyapi.com/v1/latest?base_currency=USD&currencies=RUB")
                .header(properties.getHeaderTokenName(), properties.getToken())
                .build();
        ResponseEntity<FreeCurrencyDtoResponse> response;
        try {
            response = restTemplate
                    .exchange(request, FreeCurrencyDtoResponse.class);
            BigDecimal dollarRate = Objects.requireNonNull(response.getBody()).data().get(BEING_CONVERT_CURRENCY_NAME);
            BigDecimal amountDollars = dtoRequest.amountRub().divide(dollarRate, 2, RoundingMode.CEILING);
            return new CurrencyDtoResponse(
                    dtoRequest.transferCurrencyName(),
                    amountDollars,
                    dollarRate,
                    LocalDateTime.now()
            );
        } catch (FreeCurrencyIntegrationException e) {
            throw new FreeCurrencyIntegrationException();
        }

    }
}
