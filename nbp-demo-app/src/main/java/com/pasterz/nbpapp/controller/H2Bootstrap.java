package com.pasterz.nbpapp.controller;

import com.pasterz.nbpapp.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {

  private DataService service;

  @Autowired
  public H2Bootstrap(DataService service) {
    this.service = service;
  }

  @Override
  public void run(String... args) {
    service.updateDataBase();

    System.out.println("Show first element from db:");
    System.out.println(service.getOneByIdFromDataBase(1L));
  }
}
