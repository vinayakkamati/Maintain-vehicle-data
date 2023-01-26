package com.vehicle.repository;

import com.vehicle.model.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<CarDetails, Integer> {
}
