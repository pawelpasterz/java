package com.pasterz.nbpapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NbpApp extends Application {

  private Parent rootNode;

  public static void main(String[] args) throws Exception {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setScene(new Scene(rootNode));
    primaryStage.show();
  }

  @Override
  public void init() throws Exception {
    ConfigurableApplicationContext ctx;
    ctx = new SpringApplicationBuilder(NbpApp.class).headless(true).run();

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/nbp-demo-app.fxml"));
    fxmlLoader.setControllerFactory(ctx::getBean);

    rootNode = fxmlLoader.load();
  }
}
