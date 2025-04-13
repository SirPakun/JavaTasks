package by.kirienko.command.impl;

import by.kirienko.command.Command;
import by.kirienko.view.View;
import by.kirienko.view.ViewRegistry;

import java.util.Map;

import static by.kirienko.utils.constants.CommandParametersConstants.ACTION_PARAMETER_NAME;

public class GetActionCommand
        implements Command {

    @Override
    public View handle(Map<String, Object> parameters) {
        int actionNumber = (int) parameters.get(ACTION_PARAMETER_NAME);
        View view = ViewRegistry.findViewByNumber(actionNumber);

        return view;
    }

}
