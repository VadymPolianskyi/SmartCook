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
public class IngredientService extends BaseService<IngredientEntity, IngredientRepository> {

    public List<IngredientEntity> findByIngredientName(String ingredientName) {
        return getRepository().findByIngredientContaining(ingredientName);
    }
    public List<IngredientEntity> findByDishId(String dishId){
        return getRepository().findByDishId(dishId);
    }
}
