package com.polyanski;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;


@Component
public class Main extends Application {

    public static final SpringFxmlLoader loader = new SpringFxmlLoader();

    @Override
    public void start(Stage primaryStage) {
        ShowController showController = SpringFxmlLoader.applicationContext.getBean(ShowController.class);
        showController.showView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
