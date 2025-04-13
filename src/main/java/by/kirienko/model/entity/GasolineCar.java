package by.kirienko.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class GasolineCar extends Car {
    private int fuelVolume;

    public GasolineCar() {
    }

    public GasolineCar(CarMarkEnum carMark, BigDecimal price, int speed, int fuelVolume) {
        super(carMark, price, speed);
        this.fuelVolume = fuelVolume;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        GasolineCar that = (GasolineCar) object;
        return fuelVolume == that.fuelVolume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fuelVolume);
    }

    @Override
    public String toString() {
        return "GasolineCar{" +
                "fuelVolume=" + fuelVolume +
                "} " + super.toString();
    }
}
