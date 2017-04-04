package com.polyanski;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.search.service.api.SerchService;
import com.polyanski.search.service.impl.DishSerchService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vadym_polyanski on 23.03.17.
 */
public class ShowController {
    @Autowired
    private SerchService dishSerchService;

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

        String ingredientsStr = ingredientsTextField.getText();
        List<String> allIngreds = Arrays.asList(ingredientsStr.trim().split(","));

        List<DishEntity> dishes = dishSerchService.serchingForKeys(allIngreds);
        for (DishEntity dishEntity : dishes) {
            List<IngredientEntity> ingredients = dishSerchService.getIngredientEntities(dishEntity);
            dishPanel.getChildren().add(createHBoxWithDish(dishEntity, null));
        }


    }

    private HBox createHBoxWithDish(DishEntity dish, List<IngredientEntity> ingredients) {
        HBox hBox = new HBox();
        ImageView imageView = new ImageView(new Image(dish.getImgName()));
        imageView.setFitHeight(100);
        imageView.setFitWidth(150);

        VBox vBox = new VBox();
        Label dishName = new Label(dish.getDishName());
        StringBuilder ingredStr = new StringBuilder("Ingredients: ");
        for (IngredientEntity ingredient : ingredients) {
            ingredStr.append(ingredient.getIngredient() +" (" + ingredient.getPortion() + ")");
        }

        Label ingredientName = new Label(ingredStr.toString());


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

    public void showView(Stage mainStage) {
        Parent root = (Parent) Main.loader.load("/sample.fxml");
        mainStage.setTitle("SmartCook");
        mainStage.setScene(new Scene(root));
        mainStage.setResizable(false);
        mainStage.show();
    }
}
