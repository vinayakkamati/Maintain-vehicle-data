package com.vehicle.serviceTest;

import com.vehicle.model.CarDetails;
import com.vehicle.repository.VehicleRepository;
import com.vehicle.service.serviceImpl.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static com.vehicle.mock.VoteServiceMock.getAddCarDetailsRequest;
import static com.vehicle.mock.VoteServiceMock.getCarDetails;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleServiceImplTest {

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Mock
    VehicleRepository vehicleRepository;
    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Positive case: save car details")
    void saveCarDetails() throws IOException {
        CarDetails request = getAddCarDetailsRequest();
        CarDetails carDetails = getCarDetails();
        Mockito.when(vehicleRepository.save(request)).thenReturn(carDetails);
        CarDetails actualValue = vehicleService.saveCarDetails(request);
        assertEquals(carDetails, actualValue);
    }
}