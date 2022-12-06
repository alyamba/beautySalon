package org.example.command.impl;

import org.example.command.Command;
import org.example.model.Selection;
import org.example.service.OptionService;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetOptionsCommand implements Command {
    @Override
    public JSONObject execute() {
        List<Selection> selections = OptionService.getAllOptions();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("size", selections.size());

        for (int i = 0; i < selections.size(); i++) {
            Map<String, String> map = new HashMap<>();

            map.put("name", selections.get(i).getName());
            map.put("price", String.valueOf(selections.get(i).getPrice()));

            jsonObject.put("option" + i, map);
        }
        return jsonObject;
    }
}
