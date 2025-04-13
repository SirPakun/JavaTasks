package by.kirienko.view.impl;

import by.kirienko.controller.MainController;
import by.kirienko.controller.Request;
import by.kirienko.model.entity.Car;
import by.kirienko.view.View;

import static by.kirienko.model.TaxiPark.cars;
import static by.kirienko.utils.constants.CommandParametersConstants.ACTION_PARAMETER_NAME;
import static by.kirienko.utils.constants.ViewNumbersConstants.CHOOSE_ACTION_NUMBER;

public class ShowAllCarsView implements View {
    @Override
    public void handleView() {
        System.out.println("All Cars:");
        for (Car car : cars) {
            System.out.println(car);
        }

        Request request = new Request(CHOOSE_ACTION_NUMBER);
        request.addRequestParameter(ACTION_PARAMETER_NAME, CHOOSE_ACTION_NUMBER);

        MainController.getInstance().doRequest(request).handleView();
    }
}
