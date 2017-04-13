package com.polyanski.content.parser.service.impl.edimdoma;

import com.polyanski.parser.api.AbstractImageParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:44
 */
@Component
public class EdimdomaImageParser extends AbstractImageParser {

    @Override
    public List<String> parseImages(String webSiteURL) {
        List<String> images = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect(webSiteURL).get();
            Elements links = doc.getElementsByAttributeValue("class", "card__picture");
            Elements img = links.select("img");
            for (Element el : img) {
                if (img.indexOf(el) != 0) {
                    String src = el.absUrl("src");
                    images.add(getImages(src));
                }
            }
        } catch (IOException ex) {
            System.err.println("There was an error");
            Logger.getLogger(AbstractImageParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }

}
