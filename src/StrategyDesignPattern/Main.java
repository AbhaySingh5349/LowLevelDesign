package StrategyDesignPattern;

import StrategyDesignPattern.strategy.NormalDrive;
import StrategyDesignPattern.strategy.SportsDrive;

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(new NormalDrive());
        Vehicle v2 = new Vehicle(new SportsDrive());

        v1.drive();
        v2.drive();

        Vehicle v3 = new NormalVehicle();
        Vehicle v4 = new SportsVehicle();

        v3.drive();
        v4.drive();
    }
}
