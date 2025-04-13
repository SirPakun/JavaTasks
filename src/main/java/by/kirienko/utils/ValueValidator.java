package by.kirienko.utils;

import by.kirienko.model.entity.CarMarkEnum;
import by.kirienko.model.entity.CarTypeEnum;
import by.kirienko.utils.comparators.CarComparator;
import by.kirienko.utils.comparators.ComparatorRegistry;

public class ValueValidator {

    private static final int MENU_ACTIONS = 8;
    private static final int CAR_SPEED = 60;
    private static final double CAR_PRICE = 1;
    private static final int CAR_FUEL = 1;
    private static final int CAR_CAPACITY = 1;
    private static final int MIN_AMOUNT = 1;

    public static boolean isCarSpeedValid(int speed) {
        return speed >= CAR_SPEED;
    }

    public static boolean isCarPriceValid(double price) {
        return price >= CAR_PRICE;
    }

    public static boolean isCarTypeValid(int type) {
        return (type <= CarTypeEnum.values().length)&&(type > 0);
    }

    public static boolean isCarMarkValid(int mark) {
        return (mark <= CarMarkEnum.values().length)&&(mark > 0);
    }

    public static boolean isCarFuelValid(int fuel){
        return fuel >= CAR_FUEL;
    }

    public static boolean isCarCapacityValid(int capacity){
        return capacity >= CAR_CAPACITY;
    }

    public static boolean isMenuActionValid(int action){
        return (action <= MENU_ACTIONS)&&(action > 0);
    }

    public static boolean isAmountValid(int amount){
        return (amount > MIN_AMOUNT);
    }

    public static boolean isComparatorValid(int comparator){
        return (comparator <= ComparatorRegistry.values().length)&&(comparator > 0);
    }
}
