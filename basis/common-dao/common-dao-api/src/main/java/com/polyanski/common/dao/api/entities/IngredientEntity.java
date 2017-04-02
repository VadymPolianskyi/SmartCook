package com.polyanski.common.dao.api.entities;

import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "ingredient")
    private String ingredient;

    @Column(name = "portion")
    private String portion;

    @Column(name = "dish_id")
    private String dishId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientEntity that = (IngredientEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ingredient != null ? !ingredient.equals(that.ingredient) : that.ingredient != null) return false;
        if (portion != null ? !portion.equals(that.portion) : that.portion != null) return false;
        return dishId != null ? dishId.equals(that.dishId) : that.dishId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        result = 31 * result + (portion != null ? portion.hashCode() : 0);
        result = 31 * result + (dishId != null ? dishId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IngredientEntity{" +
                "id=" + id +
                ", ingredient='" + ingredient + '\'' +
                ", portion='" + portion + '\'' +
                ", dishId='" + dishId + '\'' +
                '}';
    }
}
