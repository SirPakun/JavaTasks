package by.kirienko.utils;

import by.kirienko.model.entity.Car;
import by.kirienko.view.impl.SortCarsView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.List;

public class CarSerializer {

    public static void saveToBinary(List<Car> cars, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(cars);
        }
    }

    public static List<Car> loadFromBinary(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Car>) ois.readObject();
        }
    }
}

