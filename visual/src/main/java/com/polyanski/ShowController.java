package com.polyanski;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.search.service.api.SearchService;
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


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vadym_polyanski on 23.03.17.
 */
public class ShowController {
    @Autowired
    private SearchService dishSerchService;

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
        dishPanel.getChildren().clear();

        String ingredientsStr = ingredientsTextField.getText();
        List<String> allIngreds = Arrays.asList(ingredientsStr.trim().split(","));

        List<DishEntity> dishes = dishSerchService.serchingForKeys(allIngreds);
        for (DishEntity dishEntity : dishes) {
            List<IngredientEntity> ingredients = dishSerchService.getDetails(dishEntity);
            dishPanel.getChildren().add(createHBoxWithDish(dishEntity, ingredients));
        }


    }

    private HBox createHBoxWithDish(DishEntity dish, List<IngredientEntity> ingredients) {
        HBox hBox = new HBox();
        ImageView imageView = new ImageView( new Image("/images" + dish.getImgName()));
        imageView.setFitHeight(150);
        imageView.setFitWidth(200);
//соус,морковь,лапша,кинза,соев,сельлерей,капуста,перец,растительное,чеснок,свинина,лук,сахар,соль,банан,надуги,мука,молоко,масло,морква,капуста,чечевица,шоколад
        VBox vBox = new VBox();
        Label dishNameLabel = new Label(dish.getDishName());




        Label spase = new Label("");
        spase.setFont(Font.font(24));

        Button button = new Button("More..");
        button.setOnAction(event -> {
            openSite("https://www.edimdoma.ru" + dish.getRefference());
        });
        BackgroundImage backgroundImageBefore = new BackgroundImage( new Image( getClass().getResource("/beforeLike.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        BackgroundImage backgroundImageAfter = new BackgroundImage( new Image( getClass().getResource("/like.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundBefore = new Background(backgroundImageBefore);
        Background backgroundAfter = new Background(backgroundImageAfter);

        Button favoriteButton = new Button();
        favoriteButton.setOnAction(event -> {
            favoriteButton.setBackground(backgroundAfter);
        });
        favoriteButton.setBackground(backgroundBefore);

        Label ingredientsLabel = new Label("Ingredients: ");
        List<Label> ingredLabelList = new ArrayList<>();
        StringBuilder ingredStr = new StringBuilder();
        int counter = 0;
        for (IngredientEntity ingredient : ingredients) {
            ingredStr.append(ingredient.getIngredient() +" (" + ingredient.getPortion().replaceAll(",", "") + "), ");
            counter++;
            if (counter >= 3) {
                counter =0;
                Label ingredientsNameLabel = new Label(ingredStr.toString());
                ingredStr = new StringBuilder();
                ingredLabelList.add(ingredientsNameLabel);
            }

        }

        dishNameLabel.setFont(Font.font("Ubuntu", 22));

        vBox.getChildren().add(dishNameLabel);
        vBox.setMargin(dishNameLabel, new Insets(0,0,0,25));
        vBox.getChildren().add(ingredientsLabel);
        vBox.setMargin(ingredientsLabel, new Insets(0,0,0,25));
        for (Label ingredientsNameLabel : ingredLabelList) {
            ingredientsNameLabel.setFont(Font.font("Ubuntu", 12));
            vBox.getChildren().add(ingredientsNameLabel);
            vBox.setMargin(ingredientsNameLabel, new Insets(0,0,0,25));
        }

        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(favoriteButton);
        buttonBox.getChildren().add(button);

        vBox.getChildren().add(spase);
        vBox.getChildren().add(buttonBox);


        buttonBox.setMargin(button, new Insets(0,0,0,20));
        buttonBox.setMargin(favoriteButton, new Insets(6,0,0,40));
        vBox.setMargin(buttonBox, new Insets(0,0,0,350));

        hBox.getChildren().add(imageView);
        hBox.setMargin(imageView, new Insets(0,0,40,10));
        hBox.getChildren().add(vBox);
//        hBox.setBackground(new Background(new BackgroundFill() ));
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
