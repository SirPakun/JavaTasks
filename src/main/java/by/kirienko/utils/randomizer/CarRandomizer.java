package by.kirienko.utils.randomizer;

import by.kirienko.model.entity.CarMarkEnum;
import by.kirienko.model.entity.CarTypeEnum;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;

public class CarRandomizer {
    private static final int MIN_CAR_PRICE = 5000;
    private static final int MAX_CAR_PRICE = 100000;

    private static final int MIN_SPEED = 200;
    private static final int MAX_SPEED = 500;

    private static final int MIN_FUEL_VOLUME = 50;
    private static final int MAX_FUEL_VOLUME = 100;

    private static final int MIN_BATTERY_CAPACITY = 500;
    private static final int MAX_BATTERY_CAPACITY = 1000;

    public static final Random RANDOM = new Random();

    public CarMarkEnum getRandomCarMark() {
        int carMarkEnumLength = CarMarkEnum.values().length;
        return CarMarkEnum.values()[RANDOM.nextInt(carMarkEnumLength)];
    }

    public BigDecimal getRandomPrice() {
        int bound = MAX_CAR_PRICE - MIN_CAR_PRICE;
        return new BigDecimal(MIN_CAR_PRICE + RANDOM.nextInt(bound));
    }

    public int getRandomSpeed() {
        int bound = MAX_SPEED - MIN_SPEED;
        return MIN_SPEED + RANDOM.nextInt(bound);
    }

    public int getRandomBatteryCapacity() {
        int bound = MAX_BATTERY_CAPACITY - MIN_BATTERY_CAPACITY;
        return MIN_BATTERY_CAPACITY + RANDOM.nextInt(bound);
    }

    public int getRandomFuelVolume() {
        int bound = MAX_FUEL_VOLUME - MIN_FUEL_VOLUME;
        return MIN_FUEL_VOLUME + RANDOM.nextInt(bound);
    }

    public CarTypeEnum getRandomCarType() {
        int carTypeEnumLength = CarTypeEnum.values().length;
        return CarTypeEnum.values()[RANDOM.nextInt(carTypeEnumLength)];
    }

}
