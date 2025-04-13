package by.kirienko.view.impl;

import by.kirienko.controller.MainController;
import by.kirienko.controller.Request;
import by.kirienko.model.entity.CarMarkEnum;
import by.kirienko.model.entity.CarTypeEnum;
import by.kirienko.utils.constants.CommandParametersConstants;
import by.kirienko.view.View;
import by.kirienko.view.inputter.DataInputter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.kirienko.utils.constants.ViewNumbersConstants.ADD_CAR_NUMBER;
import static by.kirienko.utils.constants.ViewNumbersConstants.FIND_CAR_NUMBER;
import static by.kirienko.view.impl.AddCarView.*;

public class FindCarView implements View {

    private static final Logger LOGGER = LogManager.getLogger(FindCarView.class);

    @Override
    public void handleView() {

        Request request = new Request(FIND_CAR_NUMBER);

        int carTypeNumber = getCarType(request);
        getCarMark(request);
        getCarSpeed(request);
        getCarPrice(request);

        if (carTypeNumber == 1) {
            getCapacity(request);
        } else {
            getFuel(request);
        }

        MainController.getInstance().doRequest(request).handleView();
    }
}
