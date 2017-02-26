package com.polyanski.coursework.db.api.comand;

import com.polyanski.coursework.db.api.entity.Dish;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 19:55
 */
public interface DBComand {
    public void insert(Dish dish);
    public void update(Dish dish);
    public void delete(int index);
    public Dish select(int index);
}
