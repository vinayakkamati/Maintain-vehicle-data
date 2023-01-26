package com.vehicle.service.serviceImpl;

import com.vehicle.model.CarAddRequest;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public CarAddRequest saveCarDetails(CarAddRequest request) {
        return vehicleRepository.save(request);
    }
}
