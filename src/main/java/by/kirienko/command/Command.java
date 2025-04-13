package by.kirienko.command;

import by.kirienko.view.View;

import java.util.Map;

public interface Command {

    View handle(Map<String, Object> parameters);

}
