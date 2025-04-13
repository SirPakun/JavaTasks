package by.kirienko.view.impl;

import by.kirienko.controller.MainController;
import by.kirienko.controller.Request;
import by.kirienko.view.View;

import static by.kirienko.utils.constants.ViewNumbersConstants.LOAD_FROM_FILE_CARS_NUMBER;

public class LoadFromFileView implements View {

    @Override
    public void handleView() {
        Request request = new Request(LOAD_FROM_FILE_CARS_NUMBER);
        MainController.getInstance().doRequest(request).handleView();
    }
}
