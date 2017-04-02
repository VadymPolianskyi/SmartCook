package com.polyanski.parser.api;


import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;

import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:18
 */
public interface DishParser {
    public List<DishEntity> parseDishes(String webSiteURL);
    public List<IngredientEntity> getDishes();
}
