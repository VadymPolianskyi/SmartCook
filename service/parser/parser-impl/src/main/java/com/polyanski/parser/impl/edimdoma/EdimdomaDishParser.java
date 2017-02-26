package com.polyanski.parser.impl.edimdoma;

import com.polyanski.coursework.db.api.entity.Dish;
import com.polyanski.coursework.db.api.entity.Ingredient;
import com.polyanski.parser.api.AbstractImageParser;
import com.polyanski.parser.api.DishParser;
import com.polyanski.parser.api.IngredientParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:48
 */
public class EdimdomaDishParser implements DishParser {
    @Override
    public List<Dish> parseDishes(String webSiteURL) {
        List<Dish> dishes = new ArrayList<>();
        try {
            AbstractImageParser imageParser = new EdimdomaImageParser();
            IngredientParser ingredientParser = new EdimdomaIngredientParser();

            Document doc = Jsoup.connect(
                        webSiteURL).get();

            Elements headers = doc.getElementsByAttributeValue("class", "card__description");
            Elements urls = doc.select("a");


            List<String> images = imageParser.parseImages(webSiteURL);

            int dishesCountOnPage = headers.size();
            for (int i = 0; i < dishesCountOnPage; i++) {
                Element titleEl = headers.get(i);
               String title = titleEl.child(0).text();
                System.out.print(title + "\n");
                Ingredient ingredient = ingredientParser.parseIngredient(urls.get(i).attr("href"));
                Dish currentDish = createDish(headers.get(i), urls.get(i), images.get(i), ingredient);
                dishes.add(currentDish);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dishes;
    }

    private Dish createDish(Element titleEl, Element urlEl, String img, Ingredient ingredient) {
        String url, title;

        title = titleEl.child(0).text();
//        System.out.print(title + "\n");

        url = urlEl.attr("href");
//        System.out.println("URL: " + url);

        return new Dish(title, img, url, ingredient);
    }
}
