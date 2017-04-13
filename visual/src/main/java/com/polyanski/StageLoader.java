package com.polyanski;

import com.polyanski.load.LoadTask;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

/**
 * Author: vadym_polyanski
 * Date: 07.04.17
 * Time: 15:53
 */
public class StageLoader {

    private static Stage stage;

    public static void setStage(Stage newStage) {
        stage = newStage;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void showWindow(String fileName, String title) {
        Parent root = (Parent) MainApp.loader.load("/" + fileName);
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.getIcons().add(new Image("pictures/icon.png"));
        stage.show();
    }

    public static void exit() {
        stage.close();
    }
}
