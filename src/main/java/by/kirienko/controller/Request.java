package by.kirienko.controller;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private int commandNumber;
    private Map<String, Object> parameters;

    public Request() {
    }

    public Request(int commandNumber) {
        this.commandNumber = commandNumber;
        this.parameters = new HashMap<>();
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public Map<String, Object> getParameters() {
        return new HashMap<>(parameters);
    }

    public void addRequestParameter(String parameterName, Object parameter) {
        parameters.put(parameterName, parameter);
    }

}