package com.polyanski.search.service.impl;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.services.DishService;
import com.polyanski.common.dao.impl.services.IngredientService;
import com.polyanski.search.service.api.DetailsSearchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:43
 */
public abstract  class DishDetailsSearchService implements DetailsSearchService<DishEntity, IngredientEntity> {

    @Autowired
    protected DishService dishService;

    @Autowired
    protected IngredientService ingredientService;

    @Override
    public List<IngredientEntity> getDetails(DishEntity dishEntity) {
        return ingredientService.findByDishId(dishEntity.getId());
    }
}
