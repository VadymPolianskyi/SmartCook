package com.polyanski;

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
    public ShowController showController() {
        return new ShowController();
    }

    @Bean
    public SearchService dishSerchService() {
        return new DishSearchService();
    }

    @Bean
    public DishSearchFavoriteService dishSearchFavoriteService() {
        return new DishSearchFavoriteService();
    }

}
