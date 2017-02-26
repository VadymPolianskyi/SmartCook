package com.polyanski.coursework.db.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 19:09
 */
@Entity
public class Ingredient {

    @Override
    public String toString() {
        return "Ingredient{" +
                "dishId=" + dishId +
                ", ingredients='" + ingredients + '\'' +
                ", portions='" + portions + '\'' +
                '}';
    }

    @Id
    private int dishId;
    private String ingredients;
    private String portions;

    public Ingredient(String ingredients, String portions) {
        this.ingredients = ingredients;
        this.portions = portions;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPortions() {
        return portions;
    }

    public void setPortions(String portions) {
        this.portions = portions;
    }
}
