package com.polyanski.controller;

import com.polyanski.content.parser.service.api.CommonParser;
import com.polyanski.content.parser.service.impl.CommonParserImpl;
import com.polyanski.StageLoader;
import com.polyanski.load.LoadTask;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import javafx.concurrent.Task;

/**
 * Author: vadym_polyanski
 * Date: 06.04.17
 * Time: 9:21
 */
public class LoadController {

    private Stage stage;
    private int counterOfSitePage = -1;
    private final int SITE_STEP = 2;

    @Autowired
    private CommonParser commonParser;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private Label informLabel;

    @FXML
    private Pane buttonPane;

    @FXML
    public void initialize() {}

    public void yesButton() throws Exception {
        load();
    }

    public void noButton() {
        stage.close();
    }

    public Task createWorker() {
        return new LoadTask();
    }

    public void load() throws Exception {
        Task copyWorker;
        copyWorker = createWorker();
        progressIndicator.progressProperty().unbind();
        progressIndicator.progressProperty().bind(copyWorker.progressProperty());
        progressBar.progressProperty().unbind();
        progressBar.progressProperty().bind(copyWorker.progressProperty());
        copyWorker.messageProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                informLabel.setText("Have parsed " + (2+counterOfSitePage) * 16 + " dishes..");

                //if counterOfSitePage = -1 thread get first number 0 (not -1)
                Runnable task = () -> {
                    int counter = counterOfSitePage;
                    commonParser.parse(counter, counter + 1);
                };

                Thread thread = new Thread(task);
                thread.start();
                if (newValue.startsWith("100")) {
                    openMain();
                }
                counterOfSitePage += SITE_STEP;
            }
        });
        buttonPane.getChildren().clear();
        new Thread(copyWorker).start();
    }

    public void openLoad() {
        StageLoader.showWindow("load.fxml", "Loading..");
    }

    public void openMain() {
        StageLoader.showWindow("smartCook.fxml", "SmartCook");

    }
}
