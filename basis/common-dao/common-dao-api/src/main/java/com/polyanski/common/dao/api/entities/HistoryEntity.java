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
@Table(name = "history")
public class HistoryEntity implements Serializable {

    private static final long serialVersionUID = 2802295602905324404L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;

    @Column(name = "dish_id")
    private String dishId;

    @Column(name = "time")
    private Long time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryEntity historyEntity = (HistoryEntity) o;

        if (id != null ? !id.equals(historyEntity.id) : historyEntity.id != null) return false;
        if (dishId != null ? !dishId.equals(historyEntity.dishId) : historyEntity.dishId != null) return false;
        return time != null ? time.equals(historyEntity.time) : historyEntity.time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dishId != null ? dishId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
