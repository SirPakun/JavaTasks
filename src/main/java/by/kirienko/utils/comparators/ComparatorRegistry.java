package by.kirienko.utils.comparators;

import by.kirienko.view.View;
import by.kirienko.view.ViewRegistry;

import java.util.Arrays;

public enum ComparatorRegistry {
    PRICE_COMPARATOR(1, new PriceComparator()),
    SPEED_COMPARATOR(2, new SpeedComparator());

    private int comparatorNumber;
    private CarComparator carComparator;

    ComparatorRegistry(int comparatorNumber, CarComparator carComparator){
        this.comparatorNumber = comparatorNumber;
        this.carComparator = carComparator;
    }

    public int getComparatorNumber() {
        return comparatorNumber;
    }

    public CarComparator getCarComparator() {
        return carComparator;
    }

    public static CarComparator findViewByNumber(int carComparatorNumber) {
        return Arrays.stream(ComparatorRegistry.values())
                .filter(carComparator -> carComparator.getComparatorNumber() == carComparatorNumber)
                .findFirst()
                .get().getCarComparator();
    }
}
