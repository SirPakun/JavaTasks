package by.kirienko.command;

import by.kirienko.command.impl.*;

import java.util.Arrays;

import static by.kirienko.utils.constants.ViewNumbersConstants.*;

public enum CommandResolver {

    GET_ACTION_COMMAND(CHOOSE_ACTION_NUMBER, new GetActionCommand()),
    ADD_CAR_COMMAND(ADD_CAR_NUMBER, new AddCarCommand()),
    FIND_CAR_COMMAND(FIND_CAR_NUMBER, new FindCarCommand()),
    SORT_CAR_COMMAND(SORT_CAR_NUMBER,new SortCarCommand()),
    GENERATE_CARS_COMMAND(GENERATE_CAR_NUMBER, new GenerateCarsCommand()),
    SAVE_TO_FILE_COMMAND(SAVE_TO_FILE_CARS_NUMBER, new SaveToFileCommand()),
    LOAD_FROM_FILE_COMMAND(LOAD_FROM_FILE_CARS_NUMBER, new LoadFromFileCommand());

    private final int commandNumber;
    private final Command command;

    CommandResolver(int commandNumber, Command command) {
        this.commandNumber = commandNumber;
        this.command = command;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public Command getCommand() {
        return command;
    }

    public static Command findCommandByNumber(int commandNumber) {
        return Arrays.stream(CommandResolver.values())
                .filter(command -> command.commandNumber == commandNumber)
                .findFirst()
                .orElse(GET_ACTION_COMMAND)
                .getCommand();
    }
}
