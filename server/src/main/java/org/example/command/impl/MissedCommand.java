package org.example.command.impl;

import org.example.command.Command;
import org.json.simple.JSONObject;

public class MissedCommand implements Command {
    @Override
    public JSONObject execute() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "command wasn't found");
        return jsonObject;
    }
}
