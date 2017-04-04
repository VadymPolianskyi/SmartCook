package com.polyanski.search.service.api;

import java.util.List;

/**
 * Created by vadym_polyanski on 26.03.17.
 */
public interface SerchService<T, V> {
    public List<T> serchingForKeys(List<String> keys);
    public List<V> getIngredientEntities(T dishEntity);

}
