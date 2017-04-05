package com.polyanski;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.services.FavoriteDishService;
import com.polyanski.search.service.api.SearchService;
import com.polyanski.search.service.impl.DishSearchFavoriteService;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Arrays;
import java.util.List;

/**
 * Created by vadym_polyanski on 23.03.17.
 */
public class ShowController {
    @Autowired
    private SearchService dishSerchService;

    @Autowired
    private DishSearchFavoriteService dishSearchFavoriteService;

    @Autowired
    private FavoriteDishService favoriteDishService;

    //соус,морковь,лапша,кинза,соев,сельлерей,капуста,перец,растительное,чеснок,свинина,лук,сахар,соль,банан,надуги,мука,молоко,масло,морква,капуста,чечевица,шоколад


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
            dishPanel.getChildren().add(new DishHBox(dishEntity, ingredients, favoriteDishService));
        }
    }

    public void favoriteClick() {

        List<DishEntity> dishes = dishSearchFavoriteService.searchFavorites();
        for (DishEntity dishEntity : dishes) {
            List<IngredientEntity> ingredients = dishSerchService.getDetails(dishEntity);
            dishPanel.getChildren().add(new DishHBox(dishEntity, ingredients, favoriteDishService));
        }
    }





    private void clearField() {
        first.setMaxSize(0, 0);
        firstLabel.setText("");
        firstLabel.setFont(Font.font(0));
    }


    public void showView(Stage mainStage) {
        Parent root = (Parent) Main.loader.load("/smartCook.fxml");
        mainStage.setTitle("SmartCook");
        mainStage.setScene(new Scene(root));
        mainStage.setResizable(false);
        mainStage.show();
    }

}
