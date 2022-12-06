package org.example.command.impl;

import org.example.command.Command;
import org.example.model.Status;
import org.example.model.UserEntity;
import org.example.service.UserService;
import org.json.simple.JSONObject;

import java.util.List;

public class SignInCommand implements Command {
    private String login;
    private String password;
    private final List<UserEntity> users;

    public SignInCommand(JSONObject jsonObject) {
        users = UserService.getAllUsers();
        login = (String) jsonObject.get("login");
        password = (String) jsonObject.get("password");
    }

    @Override
    public JSONObject execute() {
        JSONObject sendingObject = new JSONObject();
        if(checkAdminAuthorisation()) {
            sendingObject.put("message", "ADMIN_SUCCESS");
        } else if(checkUsersAuthorisation()) {
            UserEntity userEntity = UserService.getUserByLogin(login);

            sendingObject.put("message", "USER_SUCCESS");
            sendingObject.put("phone", userEntity.getPhone());
            sendingObject.put("login", userEntity.getLogin());
            sendingObject.put("name", userEntity.getName());
        } else sendingObject.put("message", "INCORRECT_LOGIN");
        return sendingObject;
    }

    public boolean checkUsersAuthorisation() {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getStatus().equals(Status.USER)) {
                if(users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password)) return true;
            }
        }
        return false;
    }

    public boolean checkAdminAuthorisation() {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getStatus().equals(Status.ADMIN)) {
                if(users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password)) return true;
            }
        }
        return false;
    }
}
