package by.kirienko.view.inputter;

import java.util.Scanner;

public final class DataInputter {

    private final Scanner scanner = new Scanner(System.in);

    private static DataInputter instance;

    private DataInputter() {
    }

    public static DataInputter getInstance() {
        if (instance == null) {
            instance = new DataInputter();
        }

        return instance;
    }

    public int inputInt() {
        return scanner.nextInt();
    }

    public double inputDouble() {
        return scanner.nextDouble();
    }

    public String inputLine() {
        String line = scanner.nextLine();

        scanner.next();

        return line;
    }

}
