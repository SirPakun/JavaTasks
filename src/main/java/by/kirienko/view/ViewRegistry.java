package by.kirienko.view;

import by.kirienko.view.impl.*;

import java.util.Arrays;

import static by.kirienko.utils.constants.ViewNumbersConstants.*;

public enum ViewRegistry {
    ERROR_VIEW(-1, new ErrorView()),
    MAIN_MENU_VIEW(CHOOSE_ACTION_NUMBER, new MainMenuView()),
    ADD_CAR_VIEW(ADD_CAR_NUMBER, new AddCarView()),
    FIND_CAR_VIEW(FIND_CAR_NUMBER, new FindCarView()),
    SORT_CARS_VIEW(SORT_CAR_NUMBER, new SortCarsView()),
    GENERATE_RANDOM_CARS_VIEW(GENERATE_CAR_NUMBER, new GenerateRandomCarsView()),
    SHOW_CAR_VIEW(SHOW_ALL_CARS_NUMBER, new ShowAllCarsView()),
    SAVE_TO_FILE_VIEW(SAVE_TO_FILE_CARS_NUMBER, new SaveToFileView()),
    LOAD_FROM_FILE_VIEW(LOAD_FROM_FILE_CARS_NUMBER, new LoadFromFileView()),
    EXIT_VIEW(EXIT_NUMBER, new ExitView());

    private final int viewNumber;
    private final View view;

    ViewRegistry(int commandNumber, View view) {
        this.viewNumber = commandNumber;
        this.view = view;
    }

    public int getViewNumber() {
        return viewNumber;
    }

    public View getView() {
        return view;
    }

    public static View findViewByNumber(int viewNumber) {
        return Arrays.stream(ViewRegistry.values())
                .filter(view -> view.getViewNumber() == viewNumber)
                .findFirst()
                .get().getView();
    }
}
