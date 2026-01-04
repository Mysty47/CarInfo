package com.example.CarInfo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponseDTO {
    private String make;
    private String model;
    private String year;
    private Integer horsepower;
    private String drive;
    private String cylinders;
}
