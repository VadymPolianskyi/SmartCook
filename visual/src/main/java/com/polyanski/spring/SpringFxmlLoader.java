package com.polyanski.spring;

import com.polyanski.SpringApplicationConfig;
import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: vadym_polyanski
 * Date: 04.04.17
 * Time: 16:55
 */
public class SpringFxmlLoader {

    public static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            SpringApplicationConfig.class);

    public Object load(String url) {
        try {
            InputStream fxmlStream = SpringFxmlLoader.class.getResourceAsStream(url);
            System.err.println(SpringFxmlLoader.class.getResourceAsStream(url));
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override
                public Object call(Class<?> clazz) {
                    return applicationContext.getBean(clazz);
                }
            });
            return loader.load(fxmlStream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw new RuntimeException(ioException);
        }
    }
}