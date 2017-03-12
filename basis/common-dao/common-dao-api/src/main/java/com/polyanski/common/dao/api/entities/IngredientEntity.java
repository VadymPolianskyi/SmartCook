package com.polyanski.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 19:09
 */
@Entity
@Table(name = "ingredient")
public class IngredientEntity implements Serializable{

    private static final long serialVersionUID = 4860006492833185475L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "ingredient")
    private String ingredient;

    @Column(name = "portion")
    private String portion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getPortion() {
        return portion;
    }

    public void setPortion(String portion) {
        this.portion = portion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredientEntity)) return false;

        IngredientEntity that = (IngredientEntity) o;

        if (id != that.id) return false;
        if (!ingredient.equals(that.ingredient)) return false;
        return portion.equals(that.portion);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + ingredient.hashCode();
        result = 31 * result + portion.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "IngredientEntity{" +
                "id=" + id +
                ", ingredient='" + ingredient + '\'' +
                ", portion='" + portion + '\'' +
                '}';
    }
}
