package com.polyanski.parser.api;


import com.polyanski.common.dao.api.entities.DishEntity;

import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:18
 */
public interface DishParser {
    public List<DishEntity> parseDishes(String webSiteURL);
}
