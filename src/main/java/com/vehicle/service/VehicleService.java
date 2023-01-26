package com.vehicle.service;

import com.vehicle.model.CarDetails;

public interface VehicleService {
    CarDetails saveCarDetails(CarDetails request);

    CarDetails getCarDetailsById(Integer vehicleId);

    void deleteCarDetailsById(Integer vehicleId);
}
