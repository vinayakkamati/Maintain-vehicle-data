package com.vehicle.service;

import com.vehicle.model.CarAddRequest;

public interface VehicleService {
    CarAddRequest saveCarDetails(CarAddRequest request);
}
