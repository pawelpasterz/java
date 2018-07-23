package com.pasterz.nbpapp.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class CurrencyData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String currencyName;
  private String code;
  private String effectiveDate;
  private Double bid;
  private Double ask;

  public CurrencyData() {}

  public CurrencyData(
      String currencyName, String code, String effectiveDate, Double bid, Double ask) {
    this.currencyName = currencyName;
    this.code = code;
    this.effectiveDate = effectiveDate;
    this.bid = bid;
    this.ask = ask;
  }

  public String getCurrencyName() {
    return currencyName;
  }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(String effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public Double getBid() {
    return bid;
  }

  public Double getAsk() {
    return ask;
  }

  public void setBid(Double bid) {
    this.bid = bid;
  }

  public void setAsk(Double ask) {
    this.ask = ask;
  }

  @Override
  public String toString() {
    return "CurrencyData{"
        + "id="
        + id
        + ", currencyName='"
        + currencyName
        + '\''
        + ", code='"
        + code
        + '\''
        + ", effectiveDate='"
        + effectiveDate
        + '\''
        + ", bid="
        + bid
        + ", ask="
        + ask
        + '}';
  }
}
