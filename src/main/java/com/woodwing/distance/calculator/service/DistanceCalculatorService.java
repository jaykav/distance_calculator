package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.calculator.IDistanceCalculator;
import com.woodwing.distance.calculator.calculator.impl.MeterDistanceCalculator;
import com.woodwing.distance.calculator.calculator.impl.YardDistanceCalculator;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class DistanceCalculatorService {

    private static Map<CalculatorTypeEnum, IDistanceCalculator> calculatorManager;

    static {
        Map<CalculatorTypeEnum, IDistanceCalculator> tempManager = new HashMap<>();
        tempManager.put(CalculatorTypeEnum.METER, new MeterDistanceCalculator());
        tempManager.put(CalculatorTypeEnum.YARD, new YardDistanceCalculator());
        calculatorManager = Collections.unmodifiableMap(tempManager);
    }

}
