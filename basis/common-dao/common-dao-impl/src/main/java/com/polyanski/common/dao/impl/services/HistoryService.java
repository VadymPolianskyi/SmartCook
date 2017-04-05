package com.polyanski.common.dao.impl.services;

import com.polyanski.common.dao.api.entities.FavoriteDishEntity;
import com.polyanski.common.dao.api.entities.HistoryEntity;
import com.polyanski.common.dao.impl.repositories.FavoriteRepository;
import com.polyanski.common.dao.impl.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:34
 */
@Component
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public List<HistoryEntity> fingAll() {
        return historyRepository.findAll();
    }
}
