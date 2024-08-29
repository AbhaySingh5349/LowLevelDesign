package DesignPatterns.StrategyDesignPattern;

import DesignPatterns.StrategyDesignPattern.strategy.DriveStrategy;
import DesignPatterns.StrategyDesignPattern.strategy.SportsDrive;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SportsDrive());
    }
}
