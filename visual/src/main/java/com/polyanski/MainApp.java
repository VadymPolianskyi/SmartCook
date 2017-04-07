package com.polyanski;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javassist.Loader;
import org.springframework.stereotype.Component;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


@Component
public class MainApp extends Application {
    public static final SpringFxmlLoader loader = new SpringFxmlLoader();

    @Override
    public void start(Stage primaryStage) throws Exception {
//        FirstPreloader firstPreloader = new FirstPreloader();
//        firstPreloader.start(primaryStage);
        LoadController loadController = SpringFxmlLoader.applicationContext.getBean(LoadController.class);
        loadController.showWindow(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
