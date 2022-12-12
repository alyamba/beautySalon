package org.example.command.impl;

import org.example.command.Command;
import org.example.model.Category;
import org.example.model.Selection;
import org.example.service.CategoryService;
import org.example.service.SelectionService;
import org.json.simple.JSONObject;

public class AddCategoryCommand implements Command {
    private JSONObject receivedObject;

    public AddCategoryCommand(final JSONObject receivedObject) {
        this.receivedObject = receivedObject;
    }

    @Override
    public JSONObject execute() {
        String name = (String) receivedObject.get("name");

        Category category = new Category();
        category.setName(name);
        CategoryService.add(category);

        JSONObject sendingObject = new JSONObject();
        sendingObject.put("message", "SUCCESS");
        return sendingObject;
    }
}

