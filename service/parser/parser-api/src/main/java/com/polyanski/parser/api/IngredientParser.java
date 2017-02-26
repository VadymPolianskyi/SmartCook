package com.polyanski.parser.api;

import com.polyanski.coursework.db.api.entity.Ingredient;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:18
 */
public interface IngredientParser {
    public Ingredient parseIngredient(String webSiteURL);
}
