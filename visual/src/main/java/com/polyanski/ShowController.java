package com.polyanski;

import com.polyanski.common.dao.api.entities.DishEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import org.springframework.beans.factory.annotation.Autowired;



import java.io.IOException;

/**
 * Created by vadym_polyanski on 23.03.17.
 */
public class ShowController {

    public void setMain(Main main) {
        this.main = main;
    }

    @Autowired
    private Main main;


    @FXML
    private VBox dishPanel;

    @FXML
    private TextField ingredientsTextField;

    @FXML
    private AnchorPane first;

    @FXML
    private Label firstLabel;


    public void buttonClick() {
        clearField();
        DishEntity dishEntity = new DishEntity();
        dishEntity.setDishName("Dish name");
        dishEntity.setRefference("http://www.google.com/");
        dishPanel.getChildren().add(createHBoxWithDish(dishEntity));
    }

    private HBox createHBoxWithDish(DishEntity dish) {
        HBox hBox = new HBox();
        ImageView imageView = new ImageView(new Image("/image.jpg"));
        imageView.setFitHeight(100);
        imageView.setFitWidth(150);

        VBox vBox = new VBox();
        Label dishName = new Label(dish.getDishName());
        Label ingredientName = new Label("Ingredients: potato");


        dishName.setFont(Font.font(22));
        ingredientName.setFont(Font.font(14));
        Label spase = new Label("");
        Button button = new Button("More..");
        spase.setFont(Font.font(24));

        button.setOnAction(event -> {
            openSite(dish.getRefference());
        });


        vBox.getChildren().add(dishName);
        vBox.getChildren().add(ingredientName);
        vBox.getChildren().add(spase);
        vBox.getChildren().add(button);
        vBox.setMargin(dishName, new Insets(0,0,0,15));
        vBox.setMargin(ingredientName, new Insets(0,0,0,15));
        vBox.setMargin(button, new Insets(0,0,0,350));




        hBox.getChildren().add(imageView);
        hBox.getChildren().add(vBox);
        return hBox;
    }

    private void clearField() {
        first.setMaxSize(0, 0);
        firstLabel.setText("");
        firstLabel.setFont(Font.font(0));
    }

    private void openSite(String url) {
        try {
            new ProcessBuilder("x-www-browser", url).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
