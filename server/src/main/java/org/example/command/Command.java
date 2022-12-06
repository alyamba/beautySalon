package org.example.command;


import org.json.simple.JSONObject;

import java.io.Serializable;


public interface Command extends Serializable {
    JSONObject execute();
}

