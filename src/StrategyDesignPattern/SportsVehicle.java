package StrategyDesignPattern;

import StrategyDesignPattern.strategy.DriveStrategy;
import StrategyDesignPattern.strategy.SportsDrive;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SportsDrive());
    }
}
