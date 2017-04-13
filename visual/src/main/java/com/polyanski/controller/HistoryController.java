package com.polyanski.controller;

import com.polyanski.StageLoader;
import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.HistoryEntity;
import com.polyanski.common.dao.impl.services.DishService;
import com.polyanski.common.dao.impl.services.HistoryService;
import com.polyanski.elements.HistoryHBox;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 09.04.17
 * Time: 21:09
 */
@Component
public class HistoryController extends WindowController{

    @Autowired
    private HistoryService historyService;

    @Autowired
    private DishService dishService;

    @FXML
    private VBox dishPanel;

    @FXML
    public void initialize() {
        dishPanel.getChildren().clear();
        List<HistoryEntity> historyEntities = historyService.fingAll();
        for (HistoryEntity historyEntity : historyEntities) {
            DishEntity dishEntity = dishService.findByDishId(historyEntity.getDishUuid());
            dishPanel.getChildren().add(new HistoryHBox(dishEntity, "time"));
        }
    }

    public void closeButtonClick() {
        StageLoader.showWindow("smartCook.fxml", "SmartCook");
    }
}
