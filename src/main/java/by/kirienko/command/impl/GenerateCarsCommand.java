package by.kirienko.command.impl;

import by.kirienko.command.Command;
import by.kirienko.model.TaxiPark;
import by.kirienko.model.entity.Car;
import by.kirienko.utils.randomizer.RandomCarFactory;
import by.kirienko.view.View;
import by.kirienko.view.ViewRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Map;

import static by.kirienko.utils.constants.CommandParametersConstants.AMOUNT_PARAMETER_NAME;

public class GenerateCarsCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger(GenerateCarsCommand.class);

    @Override
    public View handle(Map<String, Object> parameters) {

        int amount = getAmount(parameters);
        RandomCarFactory randomCarFactory = new RandomCarFactory();

        Car[] cars = randomCarFactory.createRandomCars(amount);

        LOGGER.info("{} Cars have been generated", amount);

        Collections.addAll(TaxiPark.cars, cars);

        return ViewRegistry.MAIN_MENU_VIEW.getView();
    }

    public int getAmount(Map<String, Object> parameters) {
        return (int) parameters.get(AMOUNT_PARAMETER_NAME);
    }
}
