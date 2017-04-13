package com.polyanski.content.parser.service.impl.edimdoma;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.parser.api.AbstractImageParser;
import com.polyanski.parser.api.DishParser;
import com.polyanski.parser.api.IngredientParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:48
 */
@Component
public class EdimdomaDishParser implements DishParser {

    private final String URL = "https://www.edimdoma.ru";

    @Autowired
    private AbstractImageParser imageParser;
    @Autowired
    private IngredientParser ingredientParser;

    @Override
    public List<DishEntity> parseDishes(String webSiteURL) {
        List<DishEntity> dishes = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(
                        webSiteURL).get();

            Elements headers = doc.getElementsByAttributeValue("class", "card__description");
            Elements urls = headers.select("a");


            List<String> images = imageParser.parseImages(webSiteURL);

            int dishesCountOnPage = headers.size();
            for (int i = 0; i < dishesCountOnPage; i++) {
                DishEntity currentDish = createDish(headers.get(i), urls.get(i), images.get(i));
                dishes.add(currentDish);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishes;
    }

    private DishEntity createDish(Element titleEl, Element urlEl, String img) {
        String url, title;

        title = titleEl.child(0).text();
        url = urlEl.attr("href");

        DishEntity dish = new DishEntity();
        dish.setDishName(title);
        dish.setImgName(img);
        dish.setRefference(url);

        return dish;
    }

    @Override
    public List<IngredientEntity> getIngredients(DishEntity dishEntity) {
        return ingredientParser.parseIngredient(URL + dishEntity.getRefference());
    }
}
