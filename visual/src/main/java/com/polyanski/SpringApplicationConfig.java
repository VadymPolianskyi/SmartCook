package com.polyanski;

import com.polyanski.common.dao.impl.services.FavoriteDishService;
import com.polyanski.common.dao.impl.services.HistoryService;
import com.polyanski.controller.HistoryController;
import com.polyanski.controller.MainController;
import com.polyanski.controller.LoadController;
import com.polyanski.controller.FavoriteController;
import com.polyanski.search.service.api.SearchService;
import com.polyanski.search.service.impl.DishSearchFavoriteService;
import com.polyanski.search.service.impl.DishSearchService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Author: vadym_polyanski
 * Date: 04.04.17
 * Time: 16:43
 */
@Configuration
@Lazy
@ComponentScan(basePackages = {"com.polyanski"})
public class SpringApplicationConfig {

    @Bean
    public MainController showController() {
        return new MainController();
    }

    @Bean
    public LoadController loadController() {
        return new LoadController();
    }

    @Bean
    public SearchService dishSerchService() {
        return new DishSearchService();
    }

    @Bean
    public FavoriteDishService favoriteDishService() {
        return new FavoriteDishService();
    }

    @Bean
    public HistoryService historyService() {
        return new HistoryService();
    }

    @Bean
    public DishSearchFavoriteService dishSearchFavoriteService() {
        return new DishSearchFavoriteService();
    }

    @Bean
    public FavoriteController favoriteController() {
        return new FavoriteController();
    }

    @Bean
    public HistoryController historyController() {
        return new HistoryController();
    }
}
