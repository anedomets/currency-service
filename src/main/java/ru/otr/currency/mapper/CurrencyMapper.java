package ru.otr.currency.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.otr.currency.dto.CurrencyDto;
import ru.otr.currency.entity.Currency;
import ru.otr.currency.model.CurrencyCB;

import java.util.Collection;
import java.util.List;

@Mapper
public interface CurrencyMapper {

    CurrencyMapper CURRENCY_MAPPER = Mappers.getMapper(CurrencyMapper.class);

    Currency toCurrency(CurrencyCB currencyCB);

    CurrencyDto toCurrencyDto(Currency currency);
    List<CurrencyDto> toCurrencyDtoList(Collection<Currency> collection);

    List<Currency> toCurrencyList(Collection<CurrencyCB> collection);

}
