package com.polyanski.controller;

import com.polyanski.StageLoader;

/**
 * Author: vadym_polyanski
 * Date: 13.04.17
 * Time: 11:12
 */
public abstract class WindowController {
    public void favoriteClick() {
        StageLoader.showWindow("favorite.fxml", "Favorites");
    }

    public void historyClick() {
        StageLoader.showWindow("history.fxml", "History");
    }

    public void exitClick() {
        StageLoader.exit();
    }

    public void aboutClick() {
        StageLoader.showWindow("about.fxml", "About");
    }

}
