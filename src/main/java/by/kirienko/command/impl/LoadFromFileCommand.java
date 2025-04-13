package by.kirienko.command.impl;

import by.kirienko.command.Command;
import by.kirienko.model.TaxiPark;
import by.kirienko.utils.CarSerializer;
import by.kirienko.utils.constants.GlobalConstants;
import by.kirienko.view.View;
import by.kirienko.view.ViewRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class LoadFromFileCommand implements Command {

    private static final Logger LOGGER = LogManager.getLogger(LoadFromFileCommand.class);

    @Override
    public View handle(Map<String, Object> parameters) {
        try {
            TaxiPark.cars = CarSerializer.loadFromBinary(GlobalConstants.PATH);
        } catch (ClassNotFoundException | IOException e){
            System.err.println(e.getMessage());
            LOGGER.error("Error deserializing: {}", e.getMessage());
            return ViewRegistry.ERROR_VIEW.getView();
        }

        return ViewRegistry.MAIN_MENU_VIEW.getView();
    }
}
