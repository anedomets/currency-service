package ru.otr.currency.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class CurrencyRateDto {

    private Long id;
    private ZonedDateTime date;
    private ZonedDateTime previousDate;
    private String previousUrl;
    private ZonedDateTime timestamp;
    private ZonedDateTime createDate;
    private List<CurrencyDto> currencies;

}
