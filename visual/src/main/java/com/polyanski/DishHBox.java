package com.polyanski;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.services.FavoriteDishService;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 17:34
 */

public class DishHBox extends HBox{

    private FavoriteDishService favoriteDishService;

    BackgroundImage backgroundImageBefore = new BackgroundImage( new Image( getClass().getResource("/hearts/beforeLike.png")
            .toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    BackgroundImage backgroundImageAfter = new BackgroundImage( new Image( getClass().getResource("/hearts/like.png")
            .toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

    public DishHBox(DishEntity dish, List<IngredientEntity> ingredients, FavoriteDishService favoriteDishService) {
        this.favoriteDishService = favoriteDishService;
        ImageView image = imageCreation(dish.getImgName());

        this.getChildren().add(image);
        this.setMargin(image, new Insets(0,0,40,10));
        this.getChildren().add(vBoxCreation(dish, ingredients));
    }

//    elements creation is started

    private VBox vBoxCreation(DishEntity dish, List<IngredientEntity> ingredients) {
        VBox vBox = new VBox();

        Label spase = freeSpaseCreation();

        Label dishNameLabel = new Label(dish.getDishName());
        dishNameLabel.setFont(Font.font("Ubuntu", 22));

        Label ingredientsLabel = new Label("Ingredients: ");
        List<Label> ingredLabelList = ingredientsLabelListCreation(ingredients);

        HBox buttonBox = buttonBoxCreation(dish.getId(), dish.getRefference());

        vBox.getChildren().add(dishNameLabel);
        vBox.getChildren().add(ingredientsLabel);

        for (Label ingredientsNameLabel : ingredLabelList) {
            ingredientsNameLabel.setFont(Font.font("Ubuntu", 12));
            vBox.getChildren().add(ingredientsNameLabel);
            vBox.setMargin(ingredientsNameLabel, new Insets(0,0,0,25));
        }

        vBox.getChildren().add(spase);
        vBox.getChildren().add(buttonBox);

        vBox.setMargin(dishNameLabel, new Insets(0,0,0,25));
        vBox.setMargin(ingredientsLabel, new Insets(0,0,0,25));
        vBox.setMargin(buttonBox, new Insets(0,0,0,400));
        return vBox;
    }

    private HBox buttonBoxCreation(String dishId, String dishRefference) {
        HBox buttonBox = new HBox();
        Button moreButton = moreButtonCreation(dishRefference);
        Button favoriteHeartButton = favoriteHeartButtonCreation(dishId);

        buttonBox.getChildren().add(favoriteHeartButton);
        buttonBox.getChildren().add(moreButton);
        buttonBox.setMargin(moreButton, new Insets(0,0,0,20));
        buttonBox.setMargin(favoriteHeartButton, new Insets(6,0,0,40));
        return buttonBox;
    }

    private List<Label> ingredientsLabelListCreation(List<IngredientEntity> ingredients) {
        List<Label> ingredientLabelList = new ArrayList<>();

        StringBuilder ingredStr = new StringBuilder();
        int counterOfIngredients = 0;
        for (IngredientEntity ingredient : ingredients) {
            ingredStr.append(ingredient.getIngredient() +" (" + ingredient.getPortion().replaceAll(",", "") + "), ");
            counterOfIngredients++;
            if (counterOfIngredients >= 3/* && ingredStr.toString().length() > 450*/) {
                Label ingredientsNameLabel = new Label(ingredStr.toString());
                ingredientLabelList.add(ingredientsNameLabel);
                ingredStr = new StringBuilder();
                counterOfIngredients = 0;
            }

        }
        return ingredientLabelList;
    }

    private Button favoriteHeartButtonCreation(String dishId) {

        Button favoriteButton = new Button();
        Background backgroundBefore = new Background(backgroundImageBefore);
        Background backgroundAfter = new Background(backgroundImageAfter);

        favoriteButton.setOnAction(event -> {
            System.out.println(favoriteDishService == null);
            if (favoriteDishService.isInDB(dishId)){
                favoriteDishService.delete(dishId);
                favoriteButton.setBackground(backgroundBefore);
            } else {
                favoriteDishService.insert(dishId);
                favoriteButton.setBackground(backgroundAfter);
            }
        });
        favoriteButton.setBackground(backgroundBefore);
        return favoriteButton;
    }

    private Label freeSpaseCreation() {
        Label spase = new Label("");
        spase.setFont(Font.font(24));
        return spase;
    }



    private ImageView imageCreation(String url) {
        ImageView imageView = new ImageView( new Image("/images" + url));
        imageView.setFitHeight(150);
        imageView.setFitWidth(200);
        return imageView;
    }

    private Button moreButtonCreation(String dishSiteUrl) {
        Button button = new Button("More..");
        button.setOnAction(event -> {
            openSite("https://www.edimdoma.ru" + dishSiteUrl);
        });

        return button;
    }

//  elements creation is ended

    private void openSite(String url) {
        try {
            new ProcessBuilder("x-www-browser", url).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
