package DesignPatterns.CommandDesignPattern;

public class AirConditioner {
    Boolean isOn;
    Integer temperature;

    public void turnOnAC(){
        this.isOn = true;
        System.out.println("AC turned ON");
    }

    public void turnOffAC(){
        this.isOn = false;
        System.out.println("AC turned OFF");
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
        System.out.println("AC temperature changed to: " + temperature);
    }
}
