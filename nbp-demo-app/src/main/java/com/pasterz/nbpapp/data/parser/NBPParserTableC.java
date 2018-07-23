package com.pasterz.nbpapp.data.parser;

import com.pasterz.nbpapp.data.entity.CurrencyData;
import com.pasterz.nbpapp.data.model.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class NBPParserTableC implements Parser {

  @Override
  public List<CurrencyData> processListRequest(List<Result> resultList) {
    List<CurrencyData> dataList = new ArrayList<>();

    resultList.forEach(
        result ->
            Arrays.asList(result.getRates())
                .forEach(
                    rate -> {
                      CurrencyData data = new CurrencyData();
                      data.setEffectiveDate(result.getEffectiveDate());
                      data.setCode(rate.getCode());
                      data.setCurrencyName(rate.getCurrency());
                      data.setBid(rate.getBid());
                      data.setAsk(rate.getAsk());

                      dataList.add(data);
                    }));

    return dataList;
  }
}
