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
public class DishService extends BaseService<DishEntity, DishRepository> {

    public DishEntity findByDishName(String dishName) {
        return getRepository().findByDishName(dishName);
    }

    public DishEntity findByDishId(String dishId) {
        return getRepository().findById(dishId);
    }

    public DishEntity insert(DishEntity dishEntity) {
        return getRepository().save(dishEntity);
    }

    public List<DishEntity> findAll(){
        return getRepository().findAll();
    }
}
