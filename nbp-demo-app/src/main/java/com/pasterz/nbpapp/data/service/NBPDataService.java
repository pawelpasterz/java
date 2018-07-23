package com.pasterz.nbpapp.data.service;

import com.pasterz.nbpapp.data.entity.CurrencyData;
import com.pasterz.nbpapp.data.provider.DataProvider;
import com.pasterz.nbpapp.data.repository.CurrencyDataRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NBPDataService implements DataService {

  private CurrencyDataRepository repository;
  private DataProvider provider;

  @Autowired
  public NBPDataService(CurrencyDataRepository repository, DataProvider provider) {
    this.repository = repository;
    this.provider = provider;
  }

  @Override
  public void addToDataBase(CurrencyData data) {
    repository.save(data);
  }

  @Override
  public void updateDataBase() {
    provider.getNewData().forEach(currencyData -> repository.save(currencyData));
  }

  @Override
  public CurrencyData getOneByIdFromDataBase(Long id) {
    return repository.findById(id).get();
  }

  @Override
  public List<CurrencyData> getAllByCurrencyName(String currencyName) {
    return repository.findAllByCurrencyNameOrderByEffectiveDateAsc(currencyName);
  }
}
