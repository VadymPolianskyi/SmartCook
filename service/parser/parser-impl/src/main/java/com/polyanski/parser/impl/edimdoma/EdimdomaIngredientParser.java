package com.polyanski.parser.impl.edimdoma;

import com.polyanski.coursework.db.api.entity.Ingredient;
import com.polyanski.parser.api.IngredientParser;
import com.polyanski.parser.impl.edimdoma.filter.Filter;
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
public class EdimdomaIngredientParser implements IngredientParser {
    @Override
    public Ingredient parseIngredient(String webSiteURL) {
        List<String> ingredients = new ArrayList<>();
        List<String> portions = new ArrayList<>();
//        String ingredients = "";
//        String portions = "";
        try {
            Document doc = Jsoup.connect(webSiteURL).get();

            Elements ingreds = doc.getElementsByAttributeValue("class", "definition-list-table__td");
            Elements ports = doc.getElementsByAttributeValue("class",
                    "definition-list-table__td definition-list-table__td_value");

//            ingredients += onlyIngred1(ingreds);
//            portions += onlyPorts(ports);

            ingredients.addAll(onlyIngred(ingreds));
            portions.addAll(onlyPorts(ports));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Ingredient(ingredients, portions);
    }

    public String createIngredient(Element ingred) {
        String smallIngredient = ingred.ownText();
        return smallIngredient;
    }

    public String createPortion(Element portion) {
        String smallPortion = portion.ownText();
        return smallPortion;
    }

    public List<String> onlyPorts(Elements portionsEl) {
        List<String> portions = new ArrayList<>();
        for (Element portion : portionsEl) {
            String currentPortion = createPortion(portion);
            portions.add(currentPortion);
        }
        return portions;
    }

    public List<String> onlyIngred(Elements ingredientsEl) {
        List<String> ingredients = new ArrayList<>();
        for (Element ingredient : ingredientsEl) {
            String currentIngred = createIngredient1(ingredient);
            ingredients.add(currentIngred);
        }
        return ingredients;
    }

    public String createIngredient1(Element ingred) {
        Filter filter = new Filter();

        String smallIngredient = ingred.text() + ",";
        smallIngredient = filter.filter(smallIngredient);
        return smallIngredient;
    }

}
