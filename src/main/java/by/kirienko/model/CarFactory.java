package by.kirienko.model;

import by.kirienko.model.entity.Car;
import by.kirienko.model.entity.CarMarkEnum;
import by.kirienko.model.entity.CarTypeEnum;

import java.math.BigDecimal;
import java.util.Map;

import static by.kirienko.utils.constants.CommandParametersConstants.*;

public abstract class CarFactory {
    public abstract Car createCar(Map<String, Object> carParams);

    public static CarFactory getFactoryByCarType(CarTypeEnum carType) {
        switch (carType) {
            case ELECTRIC:
                return new ElectricFactory();
            case GASOLINE:
                return new GasolineFactory();
            default: return null;
        }
    }

    public static CarTypeEnum getCarType(Map<String, Object> carParams){
        return CarTypeEnum.values()[(int) carParams.get(CAR_TYPE_PARAMETER_NAME)];
    }

    protected CarMarkEnum getCarMark(Map<String, Object> carParams){
        return CarMarkEnum.values()[(int) carParams.get(CAR_MARK_PARAMETER_NAME)];
    }

    protected int getSpeed(Map<String, Object> carParams){
        return (int) carParams.get(SPEED_PARAMETER_NAME);
    }

    protected BigDecimal getPrice(Map<String, Object> carParams){
        return new BigDecimal((double) carParams.get(PRICE_PARAMETER_NAME));
    }

}
