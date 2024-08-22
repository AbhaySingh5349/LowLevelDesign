package NullObjectDesignPattern;

public class VehicleFactory {
    public static Vehicle getVehicleObject(String vehicleType){
        if(vehicleType.equals("Car")){
            return new Car();
        }
        // instead of returning "null", we are returning null object to avoid runtime exception & if-else check at multiple places
        return new NullVehicle();
    }
}
