package org.example.factory;

import org.example.command.Command;
import org.example.command.CommandEnum;

public class CommandFactory {
    private static final CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    private CommandFactory() {

    }


    public Command getCommand(CommandEnum commandName) {

        switch (commandName) {
            case SIGN_IN:
//                return new SignInCommand();
            case SIGN_UP:
//                return new SignUpCommand();

        }
        return null;
    }
}
