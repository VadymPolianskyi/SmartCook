package com.polyanski.search.service.impl;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.FavoriteDishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.common.dao.impl.services.DishService;
import com.polyanski.common.dao.impl.services.FavoriteDishService;
import com.polyanski.search.service.api.SearchFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:23
 */
@Component
public class DishSearchFavoriteService extends DishDetailsSearchService implements SearchFavoriteService<DishEntity, IngredientEntity> {

    @Autowired
    private FavoriteDishService favoriteDishService;



    @Override
    public List<DishEntity> searchFavorites() {
        List<FavoriteDishEntity> favoriteDishEntities = favoriteDishService.fingAll();
        List<DishEntity> dishEntities = new ArrayList<>();

        for (FavoriteDishEntity favoriteDishEntity : favoriteDishEntities) {
            dishEntities.add(dishDAOService.findByDishId(favoriteDishEntity.getDishUuid()));
        }
        return dishEntities;
    }
}
