package com.pasterz.nbpapp.data.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pasterz.nbpapp.data.entity.CurrencyData;
import com.pasterz.nbpapp.data.model.Result;
import com.pasterz.nbpapp.data.parser.Parser;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NBPDataProvider implements DataProvider {

  @Value("${nbp.url:}")
  private String nbpUrl;

  private Parser parser;

  public NBPDataProvider() {}

  @Autowired
  public NBPDataProvider(Parser parser) {
    this.parser = parser;
  }

  @Override
  public CurrencyData[] updateData() {
    return new CurrencyData[0];
  }

  private URL generateUrl() throws MalformedURLException {
    SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    String endDate = sfd.format(calendar.getTime());
    calendar.roll(Calendar.DAY_OF_YEAR, -92);
    String startDate = sfd.format(calendar.getTime());

    return new URL(nbpUrl + "/" + startDate + "/" + endDate);
  }

  public List<CurrencyData> getNewData() {

    ObjectMapper objectMapper = new ObjectMapper();
    List<Result> resultList = new ArrayList<>();

    try {
      Result[] results = objectMapper.readValue(generateUrl(), Result[].class);
      resultList = Arrays.asList(results);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return parser.processListRequest(resultList);
  }
}
