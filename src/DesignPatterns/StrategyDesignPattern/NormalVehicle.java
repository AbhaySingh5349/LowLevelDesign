package DesignPatterns.StrategyDesignPattern;

import DesignPatterns.StrategyDesignPattern.strategy.DriveStrategy;
import DesignPatterns.StrategyDesignPattern.strategy.NormalDrive;

public class NormalVehicle extends Vehicle{
    public NormalVehicle() {
        super(new NormalDrive());
    }
}
