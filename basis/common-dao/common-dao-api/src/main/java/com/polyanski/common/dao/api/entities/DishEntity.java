package com.polyanski.common.dao.api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "refference")
    private String refference;


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishEntity that = (DishEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dishName != null ? !dishName.equals(that.dishName) : that.dishName != null) return false;
        if (imgName != null ? !imgName.equals(that.imgName) : that.imgName != null) return false;
        return refference != null ? refference.equals(that.refference) : that.refference == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dishName != null ? dishName.hashCode() : 0);
        result = 31 * result + (imgName != null ? imgName.hashCode() : 0);
        result = 31 * result + (refference != null ? refference.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DishEntity{" +
                "id='" + id + '\'' +
                ", dishName='" + dishName + '\'' +
                ", imgName='" + imgName + '\'' +
                ", refference='" + refference + '\'' +
                '}';
    }
}
