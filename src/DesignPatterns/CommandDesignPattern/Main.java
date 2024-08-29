package DesignPatterns.CommandDesignPattern;

public class Main {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();

        RemoteControlInvoker remoteControlInvoker = new RemoteControlInvoker();

        remoteControlInvoker.setCommand(new TurnOnAcCommand(airConditioner));
        remoteControlInvoker.pressButton();

        remoteControlInvoker.undo();
    }
}
