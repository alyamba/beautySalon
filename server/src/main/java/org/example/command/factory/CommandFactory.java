package org.example.command.factory;

import org.example.command.Command;
import org.example.command.impl.*;
import org.json.simple.JSONObject;

public class CommandFactory {
    public Command getCommand(JSONObject jsonObject) {
        switch ((String) jsonObject.get("requestType")) {
            case "SIGN_UP":
                return new SignUpCommand(jsonObject);
            case "SIGN_IN":
                return new SignInCommand(jsonObject);
            case "GET_OPTIONS":
                return new GetOptionsCommand();
            case "MAKE_ORDER":
                return new MakeOrderCommand(jsonObject);
            case "GET_PERSONAL_ORDERS":
                return new GetPersonalOrdersCommand(jsonObject);
            case "GET_ALL_USERS":
                return new GetAllUsersCommand();
            case "GET_CATEGORY":
                return new GetCategoryCommand();
            case "ADD_PRODUCT":
                return new AddProductCommand(jsonObject);
            case "ADD_CATEGORY":
                return new AddCategoryCommand(jsonObject);
            default:
                return new MissedCommand();
        }
    }
}
