package com.polyanski.coursework.db.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

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
    private List<String> ingredients;
    private List<String> portions;

    public Ingredient(List<String> ingredients, List<String> portions) {
        this.ingredients = ingredients;
        this.portions = portions;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getPortions() {
        return portions;
    }

    public void setPortions(List<String> portions) {
        this.portions = portions;
    }
}
