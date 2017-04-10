package com.polyanski.common.dao.impl.services;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.impl.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym
 * Date: 12.03.17
 * Time: 23:07
 */
@Component
public class DishService {
    @Autowired
    DishRepository dishRepository;

    public DishEntity findByDishName(String dishName) {
        return dishRepository.findByDishName(dishName);
    }

    public DishEntity findByDishId(String dishId) {
        return dishRepository.findById(dishId);
    }

    public DishEntity insert(DishEntity dishEntity) {
        return dishRepository.save(dishEntity);
    }

    public List<DishEntity> findAll(){
        return dishRepository.findAll();
    }
}
