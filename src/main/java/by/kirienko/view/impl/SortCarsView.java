package by.kirienko.view.impl;

import by.kirienko.controller.MainController;
import by.kirienko.controller.Request;
import by.kirienko.exceptions.InvalidInputException;
import by.kirienko.utils.ValueValidator;
import by.kirienko.view.View;
import by.kirienko.view.inputter.DataInputter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.kirienko.utils.constants.CommandParametersConstants.COMPARATOR_PARAMETER_NAME;
import static by.kirienko.utils.constants.ViewNumbersConstants.SORT_CAR_NUMBER;

public class SortCarsView implements View {

    private static final Logger LOGGER = LogManager.getLogger(SortCarsView.class);

    @Override
    public void handleView() {
        System.out.println("Choose the parameters for sorting");
        System.out.println("1)By Price");
        System.out.println("2)By Speed");

        try {
            int option = DataInputter.getInstance().inputInt();
            if (!ValueValidator.isComparatorValid(option)) throw new InvalidInputException("Wrong sorting type");
            LOGGER.info("Sorting type: {}", option);

            Request request = new Request(SORT_CAR_NUMBER);

            request.addRequestParameter(COMPARATOR_PARAMETER_NAME, option);
            MainController.getInstance().doRequest(request).handleView();

        } catch (Exception e) {
            throw new InvalidInputException("Wrong sorting type");
        }

    }
}
