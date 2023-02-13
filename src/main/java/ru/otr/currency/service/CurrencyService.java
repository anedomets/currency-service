package ru.otr.currency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otr.currency.entity.Currency;
import ru.otr.currency.filter.CurrencyFilter;
import ru.otr.currency.repository.CurrencyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<Currency> findAllByFilter(CurrencyFilter filter) {
        return currencyRepository.findFirst2ByCharCodeInOrderByIdDesc(filter.getCharCodes());
    }

}
