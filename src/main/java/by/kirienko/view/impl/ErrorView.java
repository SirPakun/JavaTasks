package by.kirienko.view.impl;

import by.kirienko.view.View;
import by.kirienko.view.ViewRegistry;

public class ErrorView implements View {
    @Override
    public void handleView() {
        System.err.println("Something is wrong");

        ViewRegistry.MAIN_MENU_VIEW.getView().handleView();
    }
}
