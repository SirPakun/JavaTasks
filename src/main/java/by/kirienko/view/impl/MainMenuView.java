package by.kirienko.view.impl;

import by.kirienko.controller.MainController;
import by.kirienko.controller.Request;
import by.kirienko.exceptions.InvalidInputException;
import by.kirienko.utils.ValueValidator;
import by.kirienko.view.View;
import by.kirienko.view.ViewRegistry;
import by.kirienko.view.inputter.DataInputter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.kirienko.utils.constants.CommandParametersConstants.ACTION_PARAMETER_NAME;
import static by.kirienko.utils.constants.ViewNumbersConstants.CHOOSE_ACTION_NUMBER;

public class MainMenuView implements View {

    private static final Logger LOGGER = LogManager.getLogger(MainMenuView.class);

    @Override
    public void handleView() {

        System.out.println("-Options-");
        System.out.println("1)Add car");
        System.out.println("2)Find car");
        System.out.println("3)Sort car");
        System.out.println("4)Generate cars");
        System.out.println("5)Show all cars");
        System.out.println("6)Save to file");
        System.out.println("7)Load from file");
        System.out.println("8)Exit");

        try {
            System.out.print("Choose the option:");
            int option = DataInputter.getInstance().inputInt();
            if(!ValueValidator.isMenuActionValid(option)) throw new InvalidInputException("Wrong option");
            LOGGER.info("Menu option {}", option);

            Request request = new Request(CHOOSE_ACTION_NUMBER);
            request.addRequestParameter(ACTION_PARAMETER_NAME, option);

            MainController.getInstance().doRequest(request).handleView();
        } catch (Exception e) {
            LOGGER.error("Error {}", e.getMessage());
            System.err.println(e.getMessage());
            ViewRegistry.ERROR_VIEW.getView().handleView();
        }
    }
}
