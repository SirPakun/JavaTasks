package by.kirienko.command.impl;

import by.kirienko.command.Command;
import by.kirienko.model.TaxiPark;
import by.kirienko.utils.comparators.CarComparator;
import by.kirienko.utils.comparators.ComparatorRegistry;
import by.kirienko.view.View;
import by.kirienko.view.ViewRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static by.kirienko.utils.constants.CommandParametersConstants.COMPARATOR_PARAMETER_NAME;

public class SortCarCommand implements Command {

    public static final Logger LOGGER = LogManager.getLogger(SortCarCommand.class);

    @Override
    public View handle(Map<String, Object> parameters) {

        int carComparatorNumber = (int) parameters.get(COMPARATOR_PARAMETER_NAME);

        CarComparator carComparator = ComparatorRegistry.findViewByNumber(carComparatorNumber);

        TaxiPark.cars.sort(carComparator);

        LOGGER.info("Cars have been sorted");

        return ViewRegistry.MAIN_MENU_VIEW.getView();
    }
}
