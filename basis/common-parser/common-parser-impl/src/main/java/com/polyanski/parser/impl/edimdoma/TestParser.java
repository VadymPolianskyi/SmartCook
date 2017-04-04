package com.polyanski.parser.impl.edimdoma;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.parser.api.DishParser;
import com.polyanski.parser.impl.edimdoma.EdimdomaDishParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:43
 */
public class TestParser {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.polyanski");
        context.refresh();

        DishParser dishParser = (EdimdomaDishParser) context.getBean("edindomaDishParser");

        List<DishEntity> dishes = dishParser.parseDishes("https://www.edimdoma.ru/retsepty?page=4");
        for (DishEntity dish : dishes) {
            System.out.println(dish);
            System.out.println(dishParser.getDishes());

        }
    }
}
