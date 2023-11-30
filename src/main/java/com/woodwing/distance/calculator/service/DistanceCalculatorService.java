package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.calculator.IDistanceCalculator;
import com.woodwing.distance.calculator.calculator.impl.MeterDistanceCalculator;
import com.woodwing.distance.calculator.calculator.impl.YardDistanceCalculator;
import com.woodwing.distance.calculator.controller.model.DistanceRequestModel;
import com.woodwing.distance.calculator.service.exception.DistanceException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class DistanceCalculatorService {

    private static Map<DistanceUnit, IDistanceCalculator> calculatorManager;

    static {
        Map<DistanceUnit, IDistanceCalculator> tempManager = new HashMap<>();
        tempManager.put(DistanceUnit.METER, new MeterDistanceCalculator());
        tempManager.put(DistanceUnit.YARD, new YardDistanceCalculator());
        calculatorManager = Collections.unmodifiableMap(tempManager);
    }

    public String calculateDistance(DistanceRequestModel model) throws DistanceException {
        return null;
    }
}
