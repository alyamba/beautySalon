package org.example.command.impl;

import org.example.command.Command;
import org.example.model.OrderInfo;
import org.example.model.OrderOption;
import org.example.service.OrderInfoService;
import org.example.service.OrderItemService;
import org.example.service.SelectionService;
import org.example.service.UserService;
import org.json.simple.JSONObject;

public class MakeOrderCommand implements Command {
    private JSONObject receivedObject;

    public MakeOrderCommand(JSONObject jsonObject) {
        receivedObject = jsonObject;
    }

    @Override
    public JSONObject execute() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUser(UserService.getUserByLogin((String) receivedObject.get("login")));
        OrderInfoService.add(orderInfo);

        for (int i = 0; i < (int) receivedObject.get("size"); i++) {
            OrderOption orderOption = new OrderOption();
            orderOption.setOrder(orderInfo);
            orderOption.setOption(SelectionService.getByName((String) receivedObject.get("name" + i)));
            OrderItemService.add(orderOption);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "SUCCESS");
        return jsonObject;
    }
}
