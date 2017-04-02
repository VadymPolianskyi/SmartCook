package com.polyanski.parser.impl.edimdoma.filter;

/**
 * Author: vadym
 * Date: 03.03.17
 * Time: 18:05
 */
public class Filter {
    public final String badElement = "Ингредиент";
    public String filter(String ingredient) {

        if (ingredient.contains(badElement)) {
            int index = ingredient.indexOf(badElement);
            ingredient = ingredient.substring(0, index/2);
        }
        return ingredient;
    }
}
