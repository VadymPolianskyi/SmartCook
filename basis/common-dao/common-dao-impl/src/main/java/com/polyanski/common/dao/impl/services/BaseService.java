package com.polyanski.common.dao.impl.services;

import com.polyanski.common.dao.api.entities.BaseEntity;
import com.polyanski.common.dao.impl.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 13.04.17
 * Time: 11:52
 */
public abstract class BaseService<T extends BaseEntity, R extends BaseRepository<T>> {

    @Autowired
    private R repository;

    public T add(T entity){
        return repository.save(entity);
    }

    public void delete(String id){
        repository.delete(id);
    }

    public T update(T entity){
        return repository.save(entity);
    }

    public List<T> getAll(){
        return repository.findAll();
    }

    public R getRepository() {
        return repository;
    }

    public T getById(String id){
        return repository.findOne(id);
    }
}
