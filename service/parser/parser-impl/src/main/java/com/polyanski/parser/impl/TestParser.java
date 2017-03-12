package com.polyanski.parser.impl;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.parser.impl.edimdoma.EdimdomaDishParser;

import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:43
 */
public class TestParser {
    public static void main(String[] args) {
        EdimdomaDishParser edimdomaDishParser = new EdimdomaDishParser();

        List<DishEntity> dishes = edimdomaDishParser.parseDishes("https://www.edimdoma.ru/retsepty?page=4");
        for (DishEntity dish : dishes) {
            System.out.println(dish);
        }
    }
}
