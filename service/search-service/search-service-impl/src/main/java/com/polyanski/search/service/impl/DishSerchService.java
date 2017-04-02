package com.polyanski.search.service.impl;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.services.DishService;
import com.polyanski.common.dao.impl.services.IngredientService;
import com.polyanski.search.service.api.SerchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vadym_polyanski on 26.03.17.
 */
@Component
public class DishSerchService implements SerchService<DishEntity, String> {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private DishService dishService;

    @Override
    public List<DishEntity> serchingForKeys(List<String> keys) {
        List<DishEntity> dishEntities = new ArrayList<>();
        List<IngredientEntity> ingredientEntities = new ArrayList<>();

        for (String ingredientName : keys) {
            ingredientEntities.addAll(ingredientService.findByIngredientName(ingredientName));
        }

        HashMap<String, Integer> counterOfIngredients = new HashMap<>();

        for (IngredientEntity ingredientEntity : ingredientEntities) {
            if (counterOfIngredients.containsKey(ingredientEntity.getDishId())) {
                Integer currentNumber = counterOfIngredients.remove(ingredientEntity.getDishId());
                counterOfIngredients.put(ingredientEntity.getDishId(), currentNumber+1);
            } else {
                counterOfIngredients.put(ingredientEntity.getDishId(), 1);
            }
        }


        return searchDishes(counterOfIngredients);
    }

    private List<DishEntity> searchDishes(HashMap<String, Integer> countOfIngred) {
        List<DishEntity> dishEntities = new ArrayList<>();

        for (String dishId : countOfIngred.keySet()) {
            DishEntity currentDish = dishService.findByDishName(dishId);
            if (checkDishToIngredient(currentDish, countOfIngred.get(dishId))) {
                dishEntities.add(currentDish);
            }
        }
        return dishEntities;
    }

    private boolean checkDishToIngredient(DishEntity dish, int countOfIngredient) {
        return ingredientService.findByDishId(dish.getId()).size() == countOfIngredient;
    }
}