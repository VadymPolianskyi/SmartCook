package com.polyanski.parser.api;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 22:27
 */
public abstract class AbstractImageParser {

    private final String folderPath = "images";

    public abstract List<String> parseImages(String webSiteURL);


    protected String getImages(String src) throws IOException {
        int indexname = src.lastIndexOf("/");
        if (indexname == src.length()) {
            src = src.substring(1, indexname);
        }
        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());
        URL url = new URL(src);
        InputStream in = url.openStream();
        name += ".jpg";
        OutputStream out = new BufferedOutputStream(new FileOutputStream( folderPath+ name));

        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.close();
        in.close();
        return name;
    }
}
