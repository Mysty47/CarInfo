package com.example.CarInfo.client;

import com.example.CarInfo.dto.CarResponseDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "XwybTwCqQKCmuQD3CTTMMA==LTtuzcTx55UCIZZT";

    public CarResponseDTO getCar(String make, String model, Integer year) {

        if (make == null || model == null || year == null) {
            throw new IllegalArgumentException("Make, model, and year are required");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key", apiKey);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("make", make);
        uriVariables.put("model", model);
        uriVariables.put("year", year);

        ResponseEntity<CarResponseDTO[]> response = restTemplate.exchange(
                "https://api.api-ninjas.com/v1/cars?make={make}&model={model}&year={year}",
                HttpMethod.GET,
                entity,
                CarResponseDTO[].class,
                uriVariables
        );

        CarResponseDTO[] cars = response.getBody();

        if (cars == null || cars.length == 0) {
            throw new RuntimeException("No car data found for " + make + " " + model + " " + year);
        }

        return cars[0];
    }
}
