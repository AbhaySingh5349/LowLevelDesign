package DesignPatterns.CommandDesignPattern;

public class TurnOffAcCommand implements ICommand{
    AirConditioner airConditioner;

    public TurnOffAcCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOffAC();
    }

    @Override
    public void undo() {
        airConditioner.turnOnAC();
    }
}
