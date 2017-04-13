package com.polyanski.controller;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.services.FavoriteDishService;
import com.polyanski.common.dao.impl.services.HistoryService;
import com.polyanski.elements.DishHBox;
import com.polyanski.search.service.api.SearchService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Arrays;
import java.util.List;

/**
 * Created by vadym_polyanski on 23.03.17.
 */
//соус,морковь,лапша,кинза,соев,сельлерей,капуста,перец,растительное,чеснок,свинина,лук,сахар,соль,банан,надуги,мука,молоко,масло,морква,капуста,чечевица,шоколад
public class MainController extends WindowController {
    @Autowired
    private SearchService dishSerchService;

    @Autowired
    private FavoriteDishService favoriteDishService;
    @Autowired
    private HistoryService historyService;

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
            dishPanel.getChildren().add(new DishHBox(dishEntity, ingredients, favoriteDishService, historyService));
        }
    }

    private void clearField() {
        first.setMaxSize(0, 0);
        firstLabel.setText("");
        firstLabel.setFont(Font.font(0));
    }
}


