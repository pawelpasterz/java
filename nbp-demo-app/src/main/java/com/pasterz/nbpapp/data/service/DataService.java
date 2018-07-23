package com.pasterz.nbpapp.data.service;

import com.pasterz.nbpapp.data.entity.CurrencyData;
import java.util.List;

public interface DataService {

  void addToDataBase(CurrencyData data);
  void updateDataBase();
  CurrencyData getOneByIdFromDataBase(Long id);
  List<CurrencyData> getAllByCurrencyName(String currencyName);
}
