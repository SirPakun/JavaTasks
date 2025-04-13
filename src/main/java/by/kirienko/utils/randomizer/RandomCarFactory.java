package by.kirienko.utils.randomizer;

import by.kirienko.model.entity.Car;
import by.kirienko.model.entity.ElectricCar;
import by.kirienko.model.entity.GasolineCar;

public class RandomCarFactory {

    private final CarRandomizer CAR_RANDOMIZER = new CarRandomizer();

    public Car createRandomCar() {
        Car car = null;

        switch (CAR_RANDOMIZER.getRandomCarType()) {
            case ELECTRIC:
                car = new ElectricCar(
                        CAR_RANDOMIZER.getRandomCarMark(),
                        CAR_RANDOMIZER.getRandomPrice(),
                        CAR_RANDOMIZER.getRandomSpeed(),
                        CAR_RANDOMIZER.getRandomBatteryCapacity());
                break;
            case GASOLINE:
                car = new GasolineCar(
                        CAR_RANDOMIZER.getRandomCarMark(),
                        CAR_RANDOMIZER.getRandomPrice(),
                        CAR_RANDOMIZER.getRandomSpeed(),
                        CAR_RANDOMIZER.getRandomFuelVolume());
                break;
            default:
                throw new RuntimeException("Unknown type");
        }
        return car;
    }

    public Car[] createRandomCars(int amount) {
        Car[] result = new Car[amount];

        for (int i = 0; i < amount; i++) {
            result[i] = createRandomCar();
        }

        return result;
    }
}
