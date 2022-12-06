package org.example.command.impl;

import org.example.command.Command;
import org.example.model.Selection;
import org.example.service.CategoryService;
import org.example.service.SelectionService;
import org.json.simple.JSONObject;

public class AddProductCommand implements Command {
    private JSONObject receivedObject;

    public AddProductCommand(final JSONObject receivedObject) {
        this.receivedObject = receivedObject;
    }

    @Override
    public JSONObject execute() {
        String name = (String) receivedObject.get("name");
        Double price = Double.parseDouble((String) receivedObject.get("price"));
        String category = (String) receivedObject.get("category");

        Selection selection = new Selection();
        selection.setCategory(CategoryService.getCategory(category));
        selection.setName(name);
        selection.setPrice(price);
        SelectionService.add(selection);

        JSONObject sendingObject = new JSONObject();
        sendingObject.put("message", "SUCCESS");
        return sendingObject;
    }
}
