package com.polyanski.common.dao.impl.repositories;

import com.polyanski.common.dao.api.entities.DishEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Author: vadym
 * Date: 08.03.17
 * Time: 16:46
 */
public interface DishRepository extends PagingAndSortingRepository<DishEntity, String> {
    DishEntity findByDishName(String dishName);
    DishEntity findById(String id);
    List<DishEntity> findAll();

}
