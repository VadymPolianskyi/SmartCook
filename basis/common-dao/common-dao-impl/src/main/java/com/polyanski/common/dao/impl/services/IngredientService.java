package com.polyanski.common.dao.impl.services;

import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 12.03.17
 * Time: 23:07
 */
@Component
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public List<IngredientEntity> findByIngredientName(String ingredientName) {
        return ingredientRepository.findByIngredient(ingredientName);
    }
    public List<IngredientEntity> findByDishId(String dishId){
        return ingredientRepository.findByDishId(dishId);
    }

    public IngredientEntity insert(IngredientEntity ingredientEntity) {
        return ingredientRepository.save(ingredientEntity);
    }
}
