package com.polyanski;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

/**
 * Author: vadym_polyanski
 * Date: 07.04.17
 * Time: 16:18
 */
@Component
public class FirstPreloader extends Preloader {
    ProgressBar bar;
    Stage stage;

    private Scene createPreloaderScene() {
        bar = new ProgressBar();
        BorderPane p = new BorderPane();
        p.setCenter(bar);
        return new Scene(p, 300, 150);
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createPreloaderScene());
        stage.show();
    }

    @Override
    public void handleProgressNotification(ProgressNotification pn) {
//        bar.setProgress(pn.getProgress());
        try {
            bar.setProgress(0.3f);
            Thread.sleep(1000);
            bar.setProgress(0.5f);
            Thread.sleep(1000);
            bar.setProgress(0.7f);
            Thread.sleep(1000);
            bar.setProgress(1f);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LoadController loadController = SpringFxmlLoader.applicationContext.getBean(LoadController.class);
        loadController.showWindow(stage);
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }
}
