package com.pasterz.nbpapp.data.parser;

import com.pasterz.nbpapp.data.entity.CurrencyData;
import com.pasterz.nbpapp.data.model.Result;
import java.util.List;

public interface Parser {

  List<CurrencyData> processListRequest(List<Result> resultList);
}
