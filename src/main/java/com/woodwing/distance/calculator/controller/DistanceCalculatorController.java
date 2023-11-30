package com.woodwing.distance.calculator.controller;

import com.woodwing.distance.calculator.controller.model.DistanceRequestModel;
import com.woodwing.distance.calculator.service.DistanceCalculatorService;
import com.woodwing.distance.calculator.service.exception.DistanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wing/v1")
public class DistanceCalculatorController {

    @Autowired
    private DistanceCalculatorService distanceCalculatorService;

    /**
     * Returns distance based on the provided  {@code DistanceRequestModel}
     *
     * @param requestModel request requirements.
     * @return returns the distance with unit. e.g: 37.5 Meters.
     */
    @GetMapping("/distance")
    public ResponseEntity<String> getDistance(@RequestBody DistanceRequestModel requestModel) {

        String distance = null;
        try {
            distance = this.distanceCalculatorService.calculateDistance(requestModel);
        } catch (DistanceException distanceException) {
            // On error return error message
            return ResponseEntity.internalServerError().body(distanceException.getMessage());
        }

        return ResponseEntity.ok(distance);
    }

}
