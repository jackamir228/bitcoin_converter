package com.example.bitcoin_converter.model;

import lombok.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
@Data
@Getter
public class CurrencyPojo {
    @NonNull
    private String name;
    @NonNull
    private BigDecimal amount;
    @NonNull
    private BigDecimal rate;
    @NonNull
    private LocalDateTime time;
}
