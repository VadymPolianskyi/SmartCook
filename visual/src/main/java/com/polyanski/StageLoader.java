package com.polyanski;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Author: vadym_polyanski
 * Date: 07.04.17
 * Time: 15:53
 */
public class StageLoader {


    public static void showWindow(Stage stage, String fileName, String title) {
        Parent root = (Parent) MainApp.loader.load("/" + fileName);
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
