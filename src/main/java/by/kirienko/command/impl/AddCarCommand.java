package by.kirienko.command.impl;

import by.kirienko.command.Command;
import by.kirienko.model.CarFactory;
import by.kirienko.model.TaxiPark;
import by.kirienko.model.entity.Car;
import by.kirienko.model.entity.CarTypeEnum;
import by.kirienko.view.View;
import by.kirienko.view.ViewRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class AddCarCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger(AddCarCommand.class);

    @Override
    public View handle(Map<String, Object> parameters) {

        CarTypeEnum carType = CarFactory.getCarType(parameters);
        CarFactory carFactory = CarFactory.getFactoryByCarType(carType);

        Car car = carFactory.createCar(parameters);
        LOGGER.info("Car is created");

        TaxiPark.cars.add(car);
        LOGGER.info("Car is added");

        return ViewRegistry.MAIN_MENU_VIEW.getView();
    }
}
