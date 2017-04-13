package com.polyanski.common.dao.impl.repositories;

import com.polyanski.common.dao.api.entities.HistoryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:33
 */
public interface HistoryRepository extends BaseRepository<HistoryEntity> {
    List<HistoryEntity> findAll();
}
