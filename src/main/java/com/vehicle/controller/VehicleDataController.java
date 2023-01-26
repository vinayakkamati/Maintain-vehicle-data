package com.vehicle.controller;

import com.vehicle.model.CarAddRequest;
import com.vehicle.service.VehicleService;
import com.vehicle.service.exceptions.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleDataController {
    private final VehicleService vehicleService;

    public VehicleDataController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody CarAddRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.saveCarDetails(request));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
    }

    @GetMapping("/cars/{vehicleId}")
    public ResponseEntity<?> getCarDetails(@PathVariable("vehicleId") Integer vehicleId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getCarDetailsById(vehicleId));
        }catch (InvalidRequestException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }


}
