package com.polyanski.controller;

import com.polyanski.common.dao.api.entities.HistoryEntity;
import com.polyanski.common.dao.impl.services.HistoryService;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 09.04.17
 * Time: 21:09
 */
@Component
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @FXML
    public void initialize() {
        List<HistoryEntity> historyEntities = historyService.fingAll();
    }


}
