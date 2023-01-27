package com.vehicle.mock;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vehicle.model.CarDetails;

import java.io.File;
import java.io.IOException;

public class VoteServiceMock {
    public static CarDetails getCarDetails() throws IOException {
        ObjectMapper objectMapper = getObjectMapper();
        CarDetails carDetails = objectMapper
                .readValue(new File("src/test/java/com/vehicle/resources/CarDetails.json"), CarDetails.class);
        return carDetails;
    }
    public static CarDetails getAddCarDetailsRequest() throws IOException {
        ObjectMapper objectMapper = getObjectMapper();
        CarDetails carDetails = objectMapper
                .readValue(new File("src/test/java/com/vehicle/resources/AddCarDetailsRequest.json"), CarDetails.class);
        return carDetails;
    }

    public static ObjectMapper getObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
