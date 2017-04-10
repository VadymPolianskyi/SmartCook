package com.polyanski.elements;

import com.polyanski.common.dao.api.entities.DishEntity;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.IOException;

/**
 * Author: vadym_polyanski
 * Date: 09.04.17
 * Time: 21:16
 */
public class HistoryHBox extends HBox {

    BackgroundImage backgroundImageBefore = new BackgroundImage( new Image( getClass().getResource("/arrow.png")
            .toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


    public HistoryHBox(DishEntity dish) {
        Label dishNameLabel = new Label(dish.getDishName());
        this.getChildren().add(dishNameLabel);
        Button goButton = createGoButton(dish.getRefference());
        this.getChildren().add(goButton);
        this.setMargin(goButton, new Insets(0,200,0,0));


    }


    private void openSite(String url) {
        try {
            new ProcessBuilder("x-www-browser", url).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Button createGoButton(String dishSiteUrl) {
        Button goButton = new Button();
        Background background = new Background(backgroundImageBefore);
        goButton.setOnAction(event -> {
            openSite("https://www.edimdoma.ru" + dishSiteUrl);
        });

        return goButton;
    }
}
