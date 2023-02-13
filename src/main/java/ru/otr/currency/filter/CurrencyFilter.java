package ru.otr.currency.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyFilter {

    @Builder.Default
    private Set<String> charCodes = Set.of("USD", "EUR");

}
