package NullObjectDesignPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle bike = VehicleFactory.getVehicleObject("Bike");
        Vehicle car = VehicleFactory.getVehicleObject("Car");

        printDetails(bike);
        printDetails(car);
    }

    private static void printDetails(Vehicle vehicle){
        System.out.println( "tank capacity: " + vehicle.getTankCapacity() + " , " + "seats: " + vehicle.getSeatingCapacity());
    }
}
