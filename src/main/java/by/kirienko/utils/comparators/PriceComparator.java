package by.kirienko.utils.comparators;

import by.kirienko.model.entity.Car;

import java.util.Comparator;

public class PriceComparator extends CarComparator {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
