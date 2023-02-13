package ru.otr.currency.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otr.currency.entity.CurrencyRate;
import ru.otr.currency.mapper.CurrencyRateMapper;
import ru.otr.currency.model.CurrencyRateCB;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyRateCBService {

    @Value("${url.cb.currency.json}")
    private String urlCBCurrencyJson;

    private final CurrencyRateService currencyRateService;

    @Scheduled(cron = "0 1 */1 ? * *")
    public void getUpdateDataByCurrency() {
        final RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(List.of(MediaType.ALL));
        restTemplate.setMessageConverters(List.of(converter));
        log.info("CURRENCY-SERVICE {}: start to update data by currency.", LocalDateTime.now());
        ResponseEntity<CurrencyRateCB> response = restTemplate.getForEntity(urlCBCurrencyJson, CurrencyRateCB.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            CurrencyRate currencyRate = CurrencyRateMapper.CURRENCY_RATE_MAPPER.toCurrencyRate(response.getBody());
            currencyRateService.save(currencyRate);
            log.info("CURRENCY-SERVICE {}: finish to update data by currency.", LocalDateTime.now());
        } else {
            log.error("CURRENCY-SERVICE {}: don't update data by currency.\nResponse: {}", LocalDateTime.now(), response);
        }
    }
}
