package by.kirienko.model;

import by.kirienko.model.entity.Car;
import by.kirienko.model.entity.CarMarkEnum;
import by.kirienko.model.entity.GasolineCar;

import java.math.BigDecimal;
import java.util.Map;

import static by.kirienko.utils.constants.CommandParametersConstants.*;

public class GasolineFactory extends CarFactory{

    @Override
    public Car createCar(Map<String, Object> carParams) {

        int speed = getSpeed(carParams);
        BigDecimal price = getPrice(carParams);
        CarMarkEnum carMark = getCarMark(carParams);
        int fuel = getFuel(carParams);

        return new GasolineCar(carMark, price, speed, fuel);
    }

    protected int getFuel(Map<String, Object> carParams){
        return (int) carParams.get(FUEL_PARAMETER_NAME);
    }
}
