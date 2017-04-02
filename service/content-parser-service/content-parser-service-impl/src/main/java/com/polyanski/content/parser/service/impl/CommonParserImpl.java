package com.polyanski.content.parser.service.impl;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.services.DishService;
import com.polyanski.common.dao.impl.services.IngredientService;
import com.polyanski.content.parser.service.api.CommonParser;
import com.polyanski.parser.impl.edimdoma.EdimdomaDishParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 01.04.17
 * Time: 10:01
 */
public class CommonParserImpl implements CommonParser {
    @Autowired
    EdimdomaDishParser edimdomaDishParser;

    @Autowired
    private DishService dishService;
    @Autowired
    private IngredientService ingredientService ;

    private int pageNumber = 0;

    @Override
    public void parse() {
        while (pageNumber < 100) {
            List<DishEntity> dishes = edimdomaDishParser.parseDishes("https://www.edimdoma.ru/retsepty?page=" + pageNumber);
            for (DishEntity dish : dishes) {
                saveToDB(dish, edimdomaDishParser.getDishes());
            }
            pageNumber++;
        }



    }

    private void saveToDB(DishEntity dish, List<IngredientEntity> ingredients) {
        dish = dishService.insert(dish);
        String dishId = dish.getId();
        for (IngredientEntity ingredient : ingredients) {
            ingredient.setDishId(dishId);
            ingredientService.insert(ingredient);
        }
    }

    public static void main(String[] args) {
        CommonParserImpl commonParser = new CommonParserImpl();
        commonParser.parse();
    }
}