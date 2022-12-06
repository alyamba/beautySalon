package org.example.command.impl;

import org.example.command.Command;
import org.example.model.UserEntity;
import org.example.service.UserService;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllUsersCommand implements Command {
    @Override
    public JSONObject execute() {
        List<UserEntity> list =  UserService.getAllUsers();
        JSONObject jsonObject = new JSONObject();

        int size = 0;
        for (int i = 0; i < list.size(); i++) {
            Map userMap = new HashMap<>();
            userMap.put("id", list.get(i).getId());
            userMap.put("name", list.get(i).getName());
            userMap.put("login", list.get(i).getLogin());

            jsonObject.put("user" +i, userMap);
            size++;
        }
        jsonObject.put("size", size);
        return jsonObject;
    }
}
