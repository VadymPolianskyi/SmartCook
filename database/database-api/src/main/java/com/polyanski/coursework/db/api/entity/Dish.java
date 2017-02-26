package com.polyanski.coursework.db.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 18:10
 */
@Entity
public class Dish {

    @Id
    private long id;
    private String dishName;
    private String imgName;
    private String refference;

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", imgName='" + imgName + '\'' +
                ", refference='" + refference + '\'' +
                ", ingredient=" + ingredient +
                '}';
    }

    private Ingredient ingredient;

    public Dish(String dishName, String imgName, String refference, Ingredient ingredient) {
        this.dishName = dishName;
        this.imgName = imgName;
        this.refference = refference;
        this.ingredient = ingredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getRefference() {
        return refference;
    }

    public void setRefference(String refference) {
        this.refference = refference;
    }
}
