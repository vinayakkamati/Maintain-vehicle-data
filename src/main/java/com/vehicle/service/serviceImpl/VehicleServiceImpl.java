package com.vehicle.service.serviceImpl;

import com.vehicle.model.CarDetails;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.service.VehicleService;
import com.vehicle.service.exceptions.InvalidRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public CarDetails saveCarDetails(CarDetails request) {
        return vehicleRepository.save(request);
    }

    @Override
    public CarDetails getCarDetailsById(Integer vehicleId) {
         return Optional.of(vehicleRepository.findById(vehicleId)).get().orElseThrow(() -> new InvalidRequestException("Unable to find vehicle of vehicle id :" + vehicleId));
    }

    @Override
    public void deleteCarDetailsById(Integer vehicleId) {
            this.vehicleRepository.deleteById(vehicleId);
    }
}
