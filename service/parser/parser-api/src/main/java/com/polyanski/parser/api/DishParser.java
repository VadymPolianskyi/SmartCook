package com.polyanski.parser.api;

import com.polyanski.coursework.db.api.entity.Dish;

import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:18
 */
public interface DishParser {
    public List<Dish> parseDishes(String webSiteURL);
}
