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


public class FindCarCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger(FindCarCommand.class);

    @Override
    public View handle(Map<String, Object> parameters) {
        CarTypeEnum carType = CarFactory.getCarType(parameters);
        CarFactory carFactory = CarFactory.getFactoryByCarType(carType);

        Car carToFind = carFactory.createCar(parameters);

        System.out.println("Found cars:");

        TaxiPark.cars.stream()
                .filter((car) -> car.equals(carToFind))
                .forEach(System.out::println);

        LOGGER.info("Cars have been found");

        return ViewRegistry.MAIN_MENU_VIEW.getView();
    }
}
