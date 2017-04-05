package com.polyanski.search.service.api;

import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 05.04.17
 * Time: 13:21
 */
public interface SearchFavoriteService<T, V> extends DetailsSearchService<T, V> {
    public List<T> searchFavorites();
}
