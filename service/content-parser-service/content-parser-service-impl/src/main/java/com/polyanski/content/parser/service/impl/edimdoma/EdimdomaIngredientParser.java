package com.polyanski.content.parser.service.impl.edimdoma;

import com.polyanski.common.dao.api.entities.IngredientEntity;
import com.polyanski.parser.api.IngredientParser;
import com.polyanski.content.parser.service.impl.edimdoma.filter.Filter;
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
public class EdimdomaIngredientParser implements IngredientParser {
    @Override
    public List<IngredientEntity> parseIngredient(String webSiteURL) {
        List<IngredientEntity> ingredientEntities = new ArrayList<>();

        List<String> ingredients = new ArrayList<>();
        List<String> portions = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(webSiteURL).get();

            Elements ingreds = doc.getElementsByAttributeValue("class", "definition-list-table__td");
            Elements ports = doc.getElementsByAttributeValue("class",
                    "definition-list-table__td definition-list-table__td_value");

            ingredients.addAll(onlyIngred(ingreds));
            portions.addAll(onlyPorts(ports));

            for (int i = 0; i < ingredients.size(); i++) {
                IngredientEntity ingredient = new IngredientEntity();
                ingredient.setIngredient(ingredients.get(i));
                ingredient.setPortion(portions.get(i));
                ingredientEntities.add(ingredient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredientEntities;
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
            String currentIngred = createIngredient(ingredient);
            ingredients.add(currentIngred);
        }
        return ingredients;
    }

    public String createIngredient(Element ingred) {
        Filter filter = new Filter();

        String smallIngredient = ingred.text() + ",";
        smallIngredient = filter.filter(smallIngredient);
        return smallIngredient;
    }

}
