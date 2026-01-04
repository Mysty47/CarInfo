package com.example.CarInfo.service;

import com.example.CarInfo.client.CarApiClient;
import com.example.CarInfo.dto.CarResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarApiClient client;

    public CarService(CarApiClient client) {
        this.client = client;
    }

    public CarResponseDTO getCarInfo(String make, String model, Integer year) {
        return client.getCar(make, model, year);
    }
}