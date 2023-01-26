package com.vehicle.repository;

import com.vehicle.model.CarAddRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<CarAddRequest, Integer> {
}
