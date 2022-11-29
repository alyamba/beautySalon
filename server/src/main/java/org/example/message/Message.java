package org.example.message;

import org.example.command.CommandEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, T> request;
    private CommandEnum command;

    public Message() {
        this.request = new HashMap<>();
    }

    public Message(Map<String, T> request, CommandEnum command) {
        this.request = request;
        this.command = command;
    }


    public Map<String, T> getRequest() {
        return request;
    }

    public T getByKey(String key) {
        return this.request.get(key);
    }

    public CommandEnum getCommand() {
        return command;
    }

    ///
    public void setCommand(CommandEnum command) {
        this.command = command;
    }

    public void add(String key, T object) {
        this.request.put(key, object);
    }
}
