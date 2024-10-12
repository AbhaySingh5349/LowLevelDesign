package Questions.RideSharingSystem.OverallApproach.controller;

import Questions.RideSharingSystem.OverallApproach.model.Ride;
import Questions.RideSharingSystem.OverallApproach.service.RideService;

public class RideController {
    RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    // in actual system, we won't be getting Ride object directly from client
    // instead it will be json which we will map using Object Mapper
    public String createRide(Ride ride){
        return rideService.createRide(ride);
    }
}
