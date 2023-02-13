package ru.otr.currency.service;

import ru.otr.currency.entity.CurrencyRate;
import ru.otr.currency.filter.CurrencyRateFilter;
import ru.otr.currency.repository.CurrencyRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyRate save(CurrencyRate currencyRate) {
        return currencyRateRepository.save(currencyRate);
    }

    public CurrencyRate findById(Long id) {
        return currencyRateRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found entity by id = " + id));
    }

    public CurrencyRate findLastCurrencyRate() {
        return currencyRateRepository.findFirstByOrderByCreateDateDesc();
    }

}
