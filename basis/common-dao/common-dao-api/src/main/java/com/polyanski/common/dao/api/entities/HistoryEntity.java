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
public class HistoryEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2802295602905324404L;

    @Column(name = "dish_uuid")
    private String dishUuid;

    @Column(name = "time")
    private Long time;

    public HistoryEntity(String dishUuid, Long time) {
        this.dishUuid = dishUuid;
        this.time = time;
    }

    public String getDishUuid() {
        return dishUuid;
    }

    public void setDishUuid(String dishUuid) {
        this.dishUuid = dishUuid;
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

        HistoryEntity that = (HistoryEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dishUuid != null ? !dishUuid.equals(that.dishUuid) : that.dishUuid != null) return false;
        return time != null ? time.equals(that.time) : that.time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dishUuid != null ? dishUuid.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
