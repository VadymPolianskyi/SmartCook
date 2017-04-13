package com.polyanski.content.parser.service.impl;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.services.DishService;
import com.polyanski.common.dao.impl.services.IngredientService;
import com.polyanski.content.parser.service.api.CommonParser;
import com.polyanski.parser.api.DishParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 01.04.17
 * Time: 10:01
 */
@Component
public class CommonParserImpl implements CommonParser {

    private final String EDIM_DOMA_PAGE_NAME = "https://www.edimdoma.ru/retsepty?page=";
    @Autowired
    private DishParser edimdomaDishParser;
    @Autowired
    private DishService dishService;
    @Autowired
    private IngredientService ingredientService ;

    @Override
    public void parse(int from, int to) {
        while (from <= to) {
            List<DishEntity> dishes = edimdomaDishParser.parseDishes(EDIM_DOMA_PAGE_NAME + from);
            for (DishEntity dish : dishes) {
                saveToDB(dish, edimdomaDishParser.getIngredients(dish));
            }
            from++;
        }
    }

    private void saveToDB(DishEntity dish, List<IngredientEntity> ingredients) {
        String dishId = dishService.insert(dish).getId();
        for (IngredientEntity ingredient : ingredients) {
            ingredient.setDishId(dishId);
            ingredientService.add(ingredient);
        }
    }


}
