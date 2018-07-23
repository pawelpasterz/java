package com.pasterz.nbpapp.data.model;

public class Rates {

  private String currency;
  private String code;
  private Double bid;
  private Double ask;

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Double getBid() {
    return bid;
  }

  public void setBid(Double bid) {
    this.bid = bid;
  }

  public Double getAsk() {
    return ask;
  }

  public void setAsk(Double ask) {
    this.ask = ask;
  }

  @Override
  public String toString() {
    return "Rates{"
        + "currency='"
        + currency
        + '\''
        + ", code='"
        + code
        + '\''
        + ", bid="
        + bid
        + ", ask="
        + ask
        + '}';
  }
}
