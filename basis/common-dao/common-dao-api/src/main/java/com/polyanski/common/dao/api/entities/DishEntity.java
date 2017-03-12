package com.polyanski.common.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 18:10
 */
@Entity
@Table(name = "dish")
public class DishEntity implements Serializable {

    private static final long serialVersionUID = -1737514696249524445L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "refference")
    private String refference;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<IngredientEntity> ingredientEntities;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<IngredientEntity> getIngredientEntities() {
        return ingredientEntities;
    }

    public void setIngredientEntities(List<IngredientEntity> ingredientEntities) {
        this.ingredientEntities = ingredientEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishEntity)) return false;

        DishEntity that = (DishEntity) o;

        if (id != that.id) return false;
        if (!dishName.equals(that.dishName)) return false;
        if (imgName != null ? !imgName.equals(that.imgName) : that.imgName != null) return false;
        if (!refference.equals(that.refference)) return false;
        return ingredientEntities.equals(that.ingredientEntities);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + dishName.hashCode();
        result = 31 * result + (imgName != null ? imgName.hashCode() : 0);
        result = 31 * result + refference.hashCode();
        result = 31 * result + ingredientEntities.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DishEntity{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", imgName='" + imgName + '\'' +
                ", refference='" + refference + '\'' +
                ", ingredientEntities=" + ingredientEntities +
                '}';
    }
}
