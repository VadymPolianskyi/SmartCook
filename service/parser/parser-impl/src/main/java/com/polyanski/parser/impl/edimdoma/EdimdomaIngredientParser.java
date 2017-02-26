package com.polyanski.parser.impl.edimdoma;

import com.polyanski.coursework.db.api.entity.Ingredient;
import com.polyanski.parser.api.IngredientParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:48
 */
public class EdimdomaIngredientParser implements IngredientParser {
    @Override
    public Ingredient parseIngredient(String webSiteURL) {
        String ingredients = "";
        String portions = "";
            try {
                System.out.println("Sites: " + webSiteURL);
                Document doc = Jsoup.connect(webSiteURL).get();

                Elements ingreds = doc.getElementsByAttributeValue("class", "checkbox checkbox_has-info");
                Elements ports = doc.getElementsByAttributeValue("class",
                        "definition-list-table__td definition-list-table__td_value");

                int dishesCountOnPage = ingreds.size();
                for (int i = 0; i < dishesCountOnPage; i++) {
                    String currentIngred = createIngredient(ingreds.get(i));
                    ingredients += currentIngred;

                    String currentPortion = createPortion(ports.get(i));
                    portions += currentPortion;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new Ingredient(ingredients, portions);
    }

    public String createIngredient(Element ingred) {
        String smallIngredient = ingred.child(0).text() + ",";
        return smallIngredient;
    }

    public String createPortion(Element portion) {
        String smallPortion = portion.child(0).text() + ",";
        return smallPortion;
    }
}
