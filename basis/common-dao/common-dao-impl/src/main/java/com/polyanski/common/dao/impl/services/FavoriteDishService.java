package com.polyanski.common.dao.impl.services;

import com.polyanski.common.dao.api.entities.FavoriteDishEntity;
import com.polyanski.common.dao.impl.repositories.FavoriteRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:34
 */
@Component
public class FavoriteDishService extends BaseService<FavoriteDishEntity, FavoriteRepository>{

    public List<FavoriteDishEntity> fingAll() {
        return getRepository().findAll();
    }

    public FavoriteDishEntity insert(String dishId) {
        FavoriteDishEntity favoriteDishEntity = new FavoriteDishEntity();
        favoriteDishEntity.setDishUuid(dishId);
        return getRepository().save(favoriteDishEntity);
    }

    public boolean isInDB(String dishId) {
        return findByDishId(dishId) != null;
    }

    public void delete(String dishId) {
        getRepository().delete(findByDishId(dishId).getId());
    }

    public FavoriteDishEntity findByDishId(String dishId) {
        try {
            return getRepository().findByDishUuid(dishId);
        } catch (Exception e) {
            return null;
        }
    }
}
