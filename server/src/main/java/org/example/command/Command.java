package org.example.command;

import org.example.message.Message;

import java.io.Serializable;


public interface Command extends Serializable {

    Message execute(Message request);

}

