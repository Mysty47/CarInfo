package com.example.CarInfo.rest;

import com.example.CarInfo.dto.CarResponseDTO;
import com.example.CarInfo.service.CarService;
import com.example.CarInfo.dto.CarInfoDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/car")
    public CarResponseDTO getCar(@RequestBody CarInfoDTO dto) {
        return carService.getCarInfo(dto.getMake(), dto.getModel(), dto.getYear());
    }
}
