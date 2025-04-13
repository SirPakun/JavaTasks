package by.kirienko.view.impl;

import by.kirienko.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExitView implements View {

    private static final Logger LOGGER = LogManager.getLogger(ExitView.class);

    @Override
    public void handleView() {
        System.out.println("Goodbye");

        LOGGER.info("Application is over");
    }
}
