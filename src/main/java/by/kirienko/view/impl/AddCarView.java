package by.kirienko.view.impl;

import by.kirienko.controller.MainController;
import by.kirienko.controller.Request;
import by.kirienko.exceptions.InvalidInputException;
import by.kirienko.model.entity.CarMarkEnum;
import by.kirienko.model.entity.CarTypeEnum;
import by.kirienko.utils.ValueValidator;
import by.kirienko.utils.constants.CommandParametersConstants;
import by.kirienko.view.View;
import by.kirienko.view.inputter.DataInputter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.kirienko.utils.constants.ViewNumbersConstants.ADD_CAR_NUMBER;

public class AddCarView implements View {

    public static final Logger LOGGER = LogManager.getLogger(AddCarView.class);

    @Override
    public void handleView() {

        Request request = new Request(ADD_CAR_NUMBER);

        int carTypeNumber = getCarType(request);
        getCarMark(request);
        getCarSpeed(request);
        getCarPrice(request);

        if (carTypeNumber == 1) {
            getCapacity(request);
        } else {
            getFuel(request);
        }

        MainController.getInstance().doRequest(request).handleView();
    }

    static void showListOfCarMark() {
        for (int i = 0; i < CarMarkEnum.values().length; i++) {
            System.out.println((i + 1) + "-" + CarMarkEnum.values()[i].getMarkName());
        }
    }

    static void showListOfCarType() {
        for (int i = 0; i < CarTypeEnum.values().length; i++) {
            System.out.println((i + 1) + "-" + CarTypeEnum.values()[i].getTypeName());
        }
    }

    static void getFuel(Request request) {
        try {
            System.out.println("Input car fuel");
            int fuel = DataInputter.getInstance().inputInt();
            if (!ValueValidator.isCarFuelValid(fuel)) throw new InvalidInputException("Wrong car fuel");

            LOGGER.info("Car fuel input {}", fuel);

            request.addRequestParameter(CommandParametersConstants.FUEL_PARAMETER_NAME, fuel);
        } catch (Exception e) {
            throw new InvalidInputException("Wrong car fuel");
        }
    }

    static void getCapacity(Request request) {
        try {
            System.out.println("Input car capacity");
            int capacity = DataInputter.getInstance().inputInt();
            if (!ValueValidator.isCarCapacityValid(capacity)) throw new InvalidInputException("Wrong car capacity");

            LOGGER.info("Car capacity input {}", capacity);

            request.addRequestParameter(CommandParametersConstants.CAPACITY_PARAMETER_NAME, capacity);
        } catch (Exception e) {
            throw new InvalidInputException("Wrong car capacity");
        }
    }

    static int getCarType(Request request) {
        try {
            System.out.println("Input choose car type");
            showListOfCarType();
            int carTypeNumber = DataInputter.getInstance().inputInt();
            if (!ValueValidator.isCarTypeValid(carTypeNumber)) throw new InvalidInputException("Wrong car type");

            LOGGER.info("Car type input {}", carTypeNumber);

            request.addRequestParameter(CommandParametersConstants.CAR_TYPE_PARAMETER_NAME, carTypeNumber - 1);
            return carTypeNumber;
        } catch (Exception e) {
            throw new InvalidInputException("Wrong car type");
        }
    }

    static void getCarMark(Request request) {
        try {
            System.out.println("Input car mark");
            showListOfCarMark();
            int carMarkNumber = DataInputter.getInstance().inputInt();
            if (!ValueValidator.isCarMarkValid(carMarkNumber)) throw new InvalidInputException("Wrong car mark");

            LOGGER.info("Car mark input {}", carMarkNumber);

            request.addRequestParameter(CommandParametersConstants.CAR_MARK_PARAMETER_NAME, carMarkNumber - 1);
        } catch (Exception e) {
            throw new InvalidInputException("Wrong car mark");
        }
    }

    static void getCarSpeed(Request request) {
        try {
            System.out.println("Input car speed");
            int speed = DataInputter.getInstance().inputInt();
            if (!ValueValidator.isCarSpeedValid(speed)) throw new InvalidInputException("Wrong car speed");

            LOGGER.info("Car speed input {}", speed);

            request.addRequestParameter(CommandParametersConstants.SPEED_PARAMETER_NAME, speed);

        } catch (Exception e) {
            throw new InvalidInputException("Wrong car speed");
        }
    }

    static void getCarPrice(Request request) {
        try {
            System.out.println("Input car price");
            double price = DataInputter.getInstance().inputDouble();
            if (!ValueValidator.isCarPriceValid(price)) throw new InvalidInputException("Wrong car price");

            LOGGER.info("Car price input {}", price);

            request.addRequestParameter(CommandParametersConstants.PRICE_PARAMETER_NAME, price);

        } catch (Exception e) {
            throw new InvalidInputException("Wrong car price");
        }
    }
}
