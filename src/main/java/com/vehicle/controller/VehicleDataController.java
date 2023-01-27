package com.vehicle.controller;

import com.vehicle.model.CarDetails;
import com.vehicle.service.VehicleService;
import com.vehicle.service.exceptions.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody CarDetails request){
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

    @PutMapping("/cars/{vehicleId}")
    public ResponseEntity<?> updateCarDetails(@PathVariable("vehicleId") Integer vehicleId,
                                              @RequestBody CarDetails request){
        try {
            CarDetails carDetails = vehicleService.getCarDetailsById(vehicleId);
            request.setVehicleId(vehicleId);
            request.getDetails().setDetailsId(carDetails.getDetails().getDetailsId());
            request.getLocation().setLocationId(carDetails.getLocation().getLocationId());
            request.getDetails().getManufacturer().setManufacturerId(carDetails.getDetails().getManufacturer().getManufacturerId());
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.saveCarDetails(request));
        }catch (InvalidRequestException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCarDetails(@PathVariable("id") Integer vehicleId){
        try{
            vehicleService.deleteCarDetailsById(vehicleId);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted car details successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vehicle Number " + vehicleId +" Does not exist");
        }
    }


}
