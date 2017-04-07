package com.polyanski;

import javafx.concurrent.Task;
import javafx.scene.control.Label;

/**
 * Author: vadym_polyanski
 * Date: 07.04.17
 * Time: 20:41
 */
public class LoadTask extends Task {

    @Override
    protected Object call() throws Exception {
        for (double i = 0; i < 1000; i++) {
            Thread.sleep(200);
            updateMessage(i/10 + "%");
            updateProgress(i + 1, 1000);
        }

        return true;
    }
}
