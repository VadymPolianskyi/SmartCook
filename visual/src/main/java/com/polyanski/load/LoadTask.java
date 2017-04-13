package com.polyanski.load;

import com.polyanski.content.parser.service.impl.CommonParserImpl;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: vadym_polyanski
 * Date: 07.04.17
 * Time: 20:41
 */
public class LoadTask extends Task {

    @Autowired
    private CommonParserImpl commonParser;

    @Override
    protected Object call() throws Exception {
        for (double i = 0; i < 1000; i++) {
            System.out.println("new step in Thread: " + i);
            if (i>0) {
                updateMessage(i/10 + "%");
                updateProgress(i + 1, 1000);
                Thread.sleep(50000);
            }

        }
        updateMessage("100%");
        return true;
    }
}
