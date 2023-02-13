package ru.otr.currency.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otr.currency.dto.CurrencyRateDto;
import ru.otr.currency.mapper.CurrencyRateMapper;
import ru.otr.currency.service.CurrencyRateService;

import static ru.otr.currency.mapper.CurrencyRateMapper.CURRENCY_RATE_MAPPER;

@RestController
@RequestMapping(value = "/api/v1/currency-rates")
@RequiredArgsConstructor
public class CurrencyRateRestController {

    private final CurrencyRateService currencyRateService;

    @GetMapping(path = "/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CurrencyRateDto> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(CURRENCY_RATE_MAPPER.toCurrencyRateDto(currencyRateService.findById(id)));
    }

    @GetMapping(path = "/last")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CurrencyRateDto> findLastCurrencyRate() {
        return ResponseEntity.ok(CURRENCY_RATE_MAPPER.toCurrencyRateDto(currencyRateService.findLastCurrencyRate()));
    }

}
