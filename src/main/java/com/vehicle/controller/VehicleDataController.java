package com.vehicle.controller;

import com.vehicle.model.CarAddRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleDataController {

    @PostMapping("/cars/add")
    public ResponseEntity<?> addCar(@RequestBody CarAddRequest request){
        return null;
    }
}
