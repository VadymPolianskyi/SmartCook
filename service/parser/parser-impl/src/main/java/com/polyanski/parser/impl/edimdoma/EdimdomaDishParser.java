package com.polyanski.parser.impl.edimdoma;

import com.polyanski.common.dao.api.entities.DishEntity;
import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.parser.api.AbstractImageParser;
import com.polyanski.parser.api.DishParser;
import com.polyanski.parser.api.IngredientParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
    @Override
    public List<DishEntity> parseDishes(String webSiteURL) {
        List<DishEntity> dishes = new ArrayList<>();
        try {
            AbstractImageParser imageParser = new EdimdomaImageParser();
            IngredientParser ingredientParser = new EdimdomaIngredientParser();

            Document doc = Jsoup.connect(
                        webSiteURL).get();

            Elements headers = doc.getElementsByAttributeValue("class", "card__description");
            Elements urls = headers.select("a");


            List<String> images = imageParser.parseImages(webSiteURL);

            int dishesCountOnPage = headers.size();
            for (int i = 0; i < dishesCountOnPage; i++) {
                List<IngredientEntity> ingredients = ingredientParser.parseIngredient("https://www.edimdoma.ru" + urls.get(i).attr("href"));
                DishEntity currentDish = createDish(headers.get(i), urls.get(i), images.get(i), ingredients);
                dishes.add(currentDish);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishes;
    }

    private DishEntity createDish(Element titleEl, Element urlEl, String img, List<IngredientEntity> ingredients) {
        String url, title;

        title = titleEl.child(0).text();
        url = urlEl.attr("href");

        DishEntity dish = new DishEntity();
        dish.setDishName(title);
        dish.setImgName(img);
        dish.setRefference(url);
        dish.setIngredientEntities(ingredients);

        return dish;
    }
}
