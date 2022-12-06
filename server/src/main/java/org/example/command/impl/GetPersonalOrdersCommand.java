package org.example.command.impl;

import org.example.command.Command;
import org.example.model.OrderInfo;
import org.example.model.OrderOption;
import org.example.service.OrderInfoService;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPersonalOrdersCommand implements Command {
    private JSONObject receivedObject;

    public GetPersonalOrdersCommand(final JSONObject receivedObject) {
        this.receivedObject = receivedObject;
    }

    @Override
    public JSONObject execute() {
        List<Object[]> list = OrderInfoService.getOrderInfo(String.valueOf(receivedObject.get("login")));
        JSONObject jsonObject = new JSONObject();

        int i = 0;
        for (Object[] obj : list) {
            OrderInfo orderInfo = (OrderInfo) obj[0];
            OrderOption orderOption = (OrderOption) obj[2];

            Map itemMap = new HashMap();
            itemMap.put("id", orderInfo.getId());
            itemMap.put("price", orderOption.getOption().getPrice());
            itemMap.put("name", orderOption.getOption().getName());

            jsonObject.put("option" + i, itemMap);
            i++;
        }
        jsonObject.put("size", i);
        return jsonObject;
    }
}
