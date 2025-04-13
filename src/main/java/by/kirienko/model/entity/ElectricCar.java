package by.kirienko.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar() {
    }

    public ElectricCar(CarMarkEnum carMark, BigDecimal price, int speed, int batteryCapacity) {
        super(carMark, price, speed);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElectricCar that = (ElectricCar) object;
        return batteryCapacity == that.batteryCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacity);
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "batteryCapacity=" + batteryCapacity +
                "} " + super.toString();
    }
}
