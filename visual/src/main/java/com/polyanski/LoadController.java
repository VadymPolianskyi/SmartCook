package com.polyanski;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
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
public class LoadController implements Controller {

    private Stage stage;
    private Task copyWorker;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private Label informLabel;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    private Pane buttonPane;

    @Autowired
    private ShowController showController;

    private static final Integer STARTTIME = 150;

    private IntegerProperty timeSeconds =
            new SimpleIntegerProperty(STARTTIME);
    @FXML
    public void initialize() {

    }

    public void load() throws Exception {
        copyWorker = createWorker();
        progressIndicator.progressProperty().unbind();
        progressIndicator.progressProperty().bind(copyWorker.progressProperty());
        progressBar.progressProperty().unbind();
        progressBar.progressProperty().bind(copyWorker.progressProperty());
        copyWorker.messageProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                informLabel.setText(newValue);
//                System.out.println(newValue);
            }
        });
        buttonPane.getChildren().clear();
        new Thread(copyWorker).start();
    }

    @Override
    public void showWindow(Stage stage) {

        this.stage = stage;
       StageLoader.showWindow(stage, "load.fxml", "Loading..");
    }

    public void yesButton() throws Exception {
        load();
//        showController.showWindow(stage);
    }

    public void noButton() {

    }

    public Task createWorker() {
        return new LoadTask();
    }
}
