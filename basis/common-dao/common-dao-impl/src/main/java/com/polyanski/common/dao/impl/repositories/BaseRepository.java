package com.polyanski.common.dao.impl.repositories;

import com.polyanski.common.dao.api.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: vadym_polyanski
 * Date: 13.04.17
 * Time: 11:53
 */
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, String> {
}
