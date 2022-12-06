package org.example.command;

import org.example.command.factory.CommandFactory;
import org.json.simple.JSONObject;

public class RequestChecker {
    private JSONObject jsonObject;
    private CommandFactory commandFactory;

    public RequestChecker(JSONObject jsonObject){
        this.jsonObject = jsonObject;
        commandFactory = new CommandFactory();
    }

    public JSONObject executingCommand() {
        Command command = commandFactory.getCommand(jsonObject);
        return command.execute();
    }
}
