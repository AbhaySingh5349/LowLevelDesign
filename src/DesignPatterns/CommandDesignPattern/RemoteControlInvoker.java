package DesignPatterns.CommandDesignPattern;

import java.util.Stack;

public class RemoteControlInvoker {
    Stack<ICommand> commandStack;
    ICommand command;

    RemoteControlInvoker(){
        commandStack = new Stack<>();
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton(){
        command.execute();
        commandStack.add(command);
    }

    public void undo(){
        if(!commandStack.isEmpty()){
            ICommand previousCommand = commandStack.pop();
            previousCommand.undo();
        }
    }
}
