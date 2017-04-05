package com.polyanski.common.dao.api.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:26
 */
@Entity
@Table(name = "favorite")
public class FavoriteDishEntity implements Serializable {

    private static final long serialVersionUID = -5437292840679941642L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "dish_uuid")
    private String dishUuid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishUuid() {
        return dishUuid;
    }

    public void setDishUuid(String dishUuid) {
        this.dishUuid = dishUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FavoriteDishEntity that = (FavoriteDishEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return dishUuid != null ? dishUuid.equals(that.dishUuid) : that.dishUuid == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dishUuid != null ? dishUuid.hashCode() : 0);
        return result;
    }
}
