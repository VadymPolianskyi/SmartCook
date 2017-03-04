package com.polyanski.parser.impl;

import com.polyanski.coursework.db.api.entity.Dish;
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

        List<Dish> dishes = edimdomaDishParser.parseDishes("https://www.edimdoma.ru/retsepty?page=4");
        for (Dish dish : dishes) {
            System.out.println(dish);
        }
    }
}
