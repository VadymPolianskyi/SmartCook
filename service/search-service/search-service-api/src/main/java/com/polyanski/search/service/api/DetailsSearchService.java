package com.polyanski.search.service.api;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:40
 */
public interface DetailsSearchService<T, V> {
    public List<V> getDetails(T entity);
}
