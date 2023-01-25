package com.vehicle.controller;

import com.vehicle.model.CarAddRequest;
import com.vehicle.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleDataController {
    private final VehicleService vehicleService;

    public VehicleDataController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/car/add")
    public ResponseEntity<?> addCar(@RequestBody CarAddRequest request){
        return null;
    }
}
