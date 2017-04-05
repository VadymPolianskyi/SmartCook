package com.polyanski.common.dao.impl.services;

import com.polyanski.common.dao.api.entities.FavoriteDishEntity;
import com.polyanski.common.dao.impl.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:34
 */
@Component
public class FavoriteDishService {

    @Autowired
    FavoriteRepository favoriteRepository;

    public List<FavoriteDishEntity> fingAll() {
        return favoriteRepository.findAll();
    }

    public FavoriteDishEntity insert(String dishId) {
        FavoriteDishEntity favoriteDishEntity = new FavoriteDishEntity();
        favoriteDishEntity.setDishUuid(dishId);
        return favoriteRepository.save(favoriteDishEntity);
    }

    public boolean isInDB(String dishId) {
        return findByDishId(dishId) != null;
    }
    public void delete(String dishId) {
        favoriteRepository.delete(findByDishId(dishId).getId());
    }

    public FavoriteDishEntity findByDishId(String dishId) {
        try {
            return favoriteRepository.findByDishUuid(dishId);
        } catch (Exception e) {
            return null;
        }
    }
}
