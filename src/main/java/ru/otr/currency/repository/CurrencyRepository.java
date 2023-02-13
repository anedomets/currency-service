package ru.otr.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otr.currency.entity.Currency;

import java.util.Collection;
import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    List<Currency> findFirst2ByCharCodeInOrderByIdDesc(Collection<String> collection);

}
