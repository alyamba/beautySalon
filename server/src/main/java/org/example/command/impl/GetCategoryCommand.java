package org.example.command.impl;

import org.example.command.Command;
import org.example.model.Category;
import org.example.model.UserEntity;
import org.example.service.CategoryService;
import org.example.service.UserService;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCategoryCommand implements Command {
    @Override
    public JSONObject execute() {
        List<Category> list = CategoryService.getCategories();
        JSONObject jsonObject = new JSONObject();

        int size = 0;
        for (int i = 0; i < list.size(); i++) {
            Map userMap = new HashMap<>();
            userMap.put("name", list.get(i).getName());

            jsonObject.put("category" +i, userMap);
            size++;
        }
        jsonObject.put("size", size);
        return jsonObject;
    }
}
