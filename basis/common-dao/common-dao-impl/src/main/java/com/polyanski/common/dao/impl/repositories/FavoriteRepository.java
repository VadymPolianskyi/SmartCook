package com.polyanski.common.dao.impl.repositories;

import com.polyanski.common.dao.api.entities.FavoriteDishEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:31
 */
public interface FavoriteRepository extends PagingAndSortingRepository<FavoriteDishEntity, String> {
    List<FavoriteDishEntity> findAll();
    FavoriteDishEntity findByDishUuid(String dishId);
}
