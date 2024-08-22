package StrategyDesignPattern;

import StrategyDesignPattern.strategy.DriveStrategy;
import StrategyDesignPattern.strategy.NormalDrive;

public class NormalVehicle extends Vehicle{
    public NormalVehicle() {
        super(new NormalDrive());
    }
}
