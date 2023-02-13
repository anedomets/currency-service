package ru.otr.currency.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.otr.currency.dto.CurrencyRateDto;
import ru.otr.currency.entity.Currency;
import ru.otr.currency.entity.CurrencyRate;
import ru.otr.currency.model.CurrencyCB;
import ru.otr.currency.model.CurrencyRateCB;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static ru.otr.currency.mapper.CurrencyMapper.CURRENCY_MAPPER;

@Mapper(uses = {CurrencyMapper.class})
public interface CurrencyRateMapper {

    CurrencyRateMapper CURRENCY_RATE_MAPPER = Mappers.getMapper(CurrencyRateMapper.class);

    @Mapping(source = "currencies", target = "currencies", qualifiedByName = "mapCurrencies")
    CurrencyRate toCurrencyRate(CurrencyRateCB currencyRateCB);

    CurrencyRateDto toCurrencyRateDto(CurrencyRate currencyRate);
    List<CurrencyRateDto> toCurrencyRateDtoList(Collection<CurrencyRate> collection);

    @Named("mapCurrencies")
    default List<Currency> mapCurrencies(Map<String, CurrencyCB> currencies) {
        return CURRENCY_MAPPER.toCurrencyList(currencies.values());
    }

}
