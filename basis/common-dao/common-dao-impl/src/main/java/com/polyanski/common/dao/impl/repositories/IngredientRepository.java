package com.polyanski.common.dao.impl.repositories;

import com.polyanski.common.dao.api.entities.IngredientEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Author: vadym
 * Date: 08.03.17
 * Time: 16:47
 */
public interface IngredientRepository extends PagingAndSortingRepository<IngredientEntity, Integer> {
    List<IngredientEntity> findByIngredientContaining(String ingredient);
    List<IngredientEntity> findByDishId(String dishId);
}
