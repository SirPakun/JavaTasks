package by.kirienko.view.impl;

import by.kirienko.controller.MainController;
import by.kirienko.controller.Request;
import by.kirienko.exceptions.InvalidInputException;
import by.kirienko.utils.ValueValidator;
import by.kirienko.view.View;
import by.kirienko.view.inputter.DataInputter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.kirienko.utils.constants.CommandParametersConstants.AMOUNT_PARAMETER_NAME;
import static by.kirienko.utils.constants.ViewNumbersConstants.GENERATE_CAR_NUMBER;

public class GenerateRandomCarsView implements View {

    private static final Logger LOGGER = LogManager.getLogger(GenerateRandomCarsView.class);

    @Override
    public void handleView() {
        System.out.println("Input amount of random cars:");

        try {
            int amount = DataInputter.getInstance().inputInt();

            LOGGER.info("Amount of random cars {}", amount);

            Request request = new Request(GENERATE_CAR_NUMBER);
            if(!ValueValidator.isAmountValid(amount)) throw new InvalidInputException("Wrong amount value");
            request.addRequestParameter(AMOUNT_PARAMETER_NAME, amount);

            MainController.getInstance().doRequest(request).handleView();
        } catch (Exception e){
            throw new InvalidInputException("Wrong amount value");
        }
    }
}
