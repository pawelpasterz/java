package com.pasterz.nbpapp.data.provider;

import com.pasterz.nbpapp.data.entity.CurrencyData;
import java.util.List;

public interface DataProvider {

  CurrencyData[] updateData();
  List<CurrencyData> getNewData();
}
