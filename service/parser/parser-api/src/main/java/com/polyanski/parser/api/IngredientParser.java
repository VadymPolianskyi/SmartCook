package com.polyanski.parser.api;

import com.polyanski.common.dao.api.entities.IngredientEntity;

import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:18
 */
public interface IngredientParser {
    public List<IngredientEntity> parseIngredient(String webSiteURL);
}
