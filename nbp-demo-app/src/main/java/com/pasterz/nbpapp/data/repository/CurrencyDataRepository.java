package com.pasterz.nbpapp.data.repository;

import com.pasterz.nbpapp.data.entity.CurrencyData;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyDataRepository extends CrudRepository<CurrencyData, Long> {

  List<CurrencyData> findAllByCurrencyNameOrderByEffectiveDateAsc(String currencyName);
}
