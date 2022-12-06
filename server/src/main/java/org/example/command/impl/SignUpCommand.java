package org.example.command.impl;

import org.example.command.Command;
import org.example.model.Status;
import org.example.model.UserEntity;
import org.example.service.UserService;
import org.json.simple.JSONObject;

import java.util.List;

public class SignUpCommand implements Command {
    private String login;
    private String password;
    private String phone;
    private String name;
    private List<UserEntity> userEntities;

    public SignUpCommand(JSONObject requestObject) {
        login = (String) requestObject.get("login");
        password = (String) requestObject.get("password");
        phone = (String) requestObject.get("phone");
        name = (String) requestObject.get("name");

        userEntities = UserService.getAllUsers();
    }

    @Override
    public JSONObject execute() {
        JSONObject jsonObject = new JSONObject();

        if(checkIfUserExists()) {
            jsonObject.put("message", "USER_EXISTS");
            return jsonObject;
        }
        UserEntity userEntity = new UserEntity();

        userEntity.setLogin(login);
        userEntity.setPassword(password);
        userEntity.setName(name);
        userEntity.setPhone(phone);
        userEntity.setStatus(Status.USER);

        UserService.add(userEntity);
        jsonObject.put("message", "SUCCESS_REG");
        return jsonObject;
    }

    public boolean checkIfUserExists() {
        for (int i = 0; i < userEntities.size(); i++) {
            if(userEntities.get(i).getLogin().equals(login)) return true;
        }
        return false;
    }
}
