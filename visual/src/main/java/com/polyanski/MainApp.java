package com.polyanski;

import com.polyanski.common.dao.impl.services.DishService;
import com.polyanski.controller.LoadController;
import com.polyanski.spring.SpringFxmlLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class MainApp extends Application {
    public static final SpringFxmlLoader loader = new SpringFxmlLoader();

    private static DishService dishService;

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoadController loadController = SpringFxmlLoader.applicationContext.getBean(LoadController.class);
        if (dishService.findAll().size() != 0) {
            loadController.showWindow(primaryStage);
            loadController.openMain();
        } else {
            loadController.showWindow(primaryStage);
        }
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.polyanski");
        context.refresh();
        dishService = (DishService) context.getBean("dishService");
        launch(args);
    }
}
