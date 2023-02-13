package ru.otr.currency.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
public class CurrencyRateCB {

    @JsonProperty("Date")
    private ZonedDateTime date;

    @JsonProperty("PreviousDate")
    private ZonedDateTime previousDate;

    @JsonProperty("PreviousURL")
    private String previousUrl;

    @JsonProperty("Timestamp")
    private ZonedDateTime timestamp;

    @JsonProperty("Valute")
    private Map<String, CurrencyCB> currencies;

}
