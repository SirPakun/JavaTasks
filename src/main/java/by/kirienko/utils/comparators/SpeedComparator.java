package by.kirienko.utils.comparators;

import by.kirienko.model.entity.Car;

import java.util.Comparator;

public class SpeedComparator extends CarComparator {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.getSpeed(), o2.getSpeed());
    }
}
