package by.kirienko.model;

import by.kirienko.model.entity.Car;
import by.kirienko.model.entity.CarMarkEnum;
import by.kirienko.model.entity.ElectricCar;

import java.math.BigDecimal;
import java.util.Map;

import static by.kirienko.utils.constants.CommandParametersConstants.CAPACITY_PARAMETER_NAME;

public class ElectricFactory extends CarFactory{

    @Override
    public Car createCar(Map<String, Object> carParams) {

        int speed = getSpeed(carParams);
        System.err.println("speed " + speed);
        BigDecimal price = getPrice(carParams);
        System.err.println("price " + price);
        CarMarkEnum carMark = getCarMark(carParams);
        System.err.println("carMark " + carMark);
        int capacity = getCapacity(carParams);
        System.err.println("capacity " + capacity);


        return new ElectricCar(carMark, price, speed, capacity);
    }

    protected int getCapacity(Map<String, Object> carParams){
        return (int) carParams.get(CAPACITY_PARAMETER_NAME);
    }
}
