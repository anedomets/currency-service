package ru.otr.currency.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otr.currency.dto.CurrencyDto;
import ru.otr.currency.filter.CurrencyFilter;
import ru.otr.currency.service.CurrencyService;

import java.util.Collection;

import static ru.otr.currency.mapper.CurrencyMapper.CURRENCY_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/currencies")
public class CurrencyRestController {

    private final CurrencyService currencyService;

    @GetMapping(path = "/by-filter")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Collection<CurrencyDto>> findAllByFilter(CurrencyFilter filter) {
        return ResponseEntity.ok(CURRENCY_MAPPER.toCurrencyDtoList(currencyService.findAllByFilter(filter)));
    }

}
