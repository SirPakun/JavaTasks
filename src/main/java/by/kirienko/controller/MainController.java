package by.kirienko.controller;

import by.kirienko.command.Command;
import by.kirienko.command.CommandResolver;
import by.kirienko.view.View;
import by.kirienko.view.ViewRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class MainController {

    public static final Logger LOGGER = LogManager.getLogger(MainController.class);

    private static MainController instance;

    private MainController() {
    }

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }

        return instance;
    }

    public View doRequest(Request request) {
        try {
            Command command = CommandResolver.findCommandByNumber(request.getCommandNumber());
            LOGGER.debug("Command : {}", command.getClass().getName());
            return command.handle(request.getParameters());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            LOGGER.error("Input error: {}", e.getMessage());
            return ViewRegistry.ERROR_VIEW.getView();
        }
    }


}
