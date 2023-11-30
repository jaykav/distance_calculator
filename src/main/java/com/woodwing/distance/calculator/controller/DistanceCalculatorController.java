package com.woodwing.distance.calculator.controller;

import com.woodwing.distance.calculator.model.DistanceRequestModel;
import com.woodwing.distance.calculator.model.RequestPointModel;
import com.woodwing.distance.calculator.service.DistanceCalculatorService;
import com.woodwing.distance.calculator.exception.DistanceException;
import com.woodwing.distance.calculator.service.DistanceUnit;
import com.woodwing.distance.calculator.service.model.Point;
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

            String distanceUnit = requestModel.getResponseDistanceUnit();

            if (distanceUnit == null || distanceUnit.isEmpty()){
                return ResponseEntity.internalServerError().body("Undefined responseDistanceUnit!");
            }

            distance = this.distanceCalculatorService.calculateDistance(convertModel(requestModel.getPointA(), "pointA"),
                    convertModel(requestModel.getPointB(), "PointB"),
                    DistanceUnit.findByAbbreviation(distanceUnit));
        } catch (DistanceException distanceException) {
            // On error return error message
            return ResponseEntity.internalServerError().body(distanceException.getMessage());
        }

        return ResponseEntity.ok(distance);
    }

    private Point convertModel(RequestPointModel pointModel, String errorPrefix) throws DistanceException {
        if (pointModel == null) throw new DistanceException(errorPrefix + " is undefined!");
        DistanceUnit distanceUnit = DistanceUnit.findByAbbreviation(pointModel.getUnit());
        return new Point(pointModel.getDistance(), distanceUnit);
    }
}
