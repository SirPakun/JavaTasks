package by.kirienko.view.impl;

import by.kirienko.controller.MainController;
import by.kirienko.controller.Request;
import by.kirienko.view.View;

import static by.kirienko.utils.constants.ViewNumbersConstants.SAVE_TO_FILE_CARS_NUMBER;

public class SaveToFileView implements View {
    @Override
    public void handleView() {
        Request request = new Request(SAVE_TO_FILE_CARS_NUMBER);
        MainController.getInstance().doRequest(request).handleView();
    }
}
