package ru.otr.currency.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyDto {

    private Long id;
    private String currencyId;
    private String numCode;
    private String charCode;
    private Integer nominal;
    private String name;
    private BigDecimal value;
    private BigDecimal previous;

}
