package by.kirienko.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public abstract class Car implements Serializable {



    private CarMarkEnum carMark;
    private BigDecimal price;
    private int speed;

    public Car() {
    }

    public Car(CarMarkEnum carMark, BigDecimal price, int speed) {
        this.carMark = carMark;
        this.price = price;
        this.speed = speed;
    }

    public CarMarkEnum getCarMark() {
        return carMark;
    }

    public void setCarMark(CarMarkEnum carMark) {
        this.carMark = carMark;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Car car = (Car) object;
        return speed == car.speed && carMark == car.carMark && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carMark, price, speed);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carMark=" + carMark +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }
}
