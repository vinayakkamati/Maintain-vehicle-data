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

    @PutMapping("/cars/{vehicleId}")
    public ResponseEntity<?> updateCarDetails(@PathVariable("vehicleId") Integer vehicleId,
                                              @RequestBody CarAddRequest request){
        try {
            CarAddRequest carAddRequest = vehicleService.getCarDetailsById(vehicleId);
            request.setVehicleId(vehicleId);
            request.getDetails().setDetailsId(carAddRequest.getDetails().getDetailsId());
            request.getLocation().setLocationId(carAddRequest.getLocation().getLocationId());
            request.getDetails().getManufacturer().setManufacturerId(carAddRequest.getDetails().getManufacturer().getManufacturerId());
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
