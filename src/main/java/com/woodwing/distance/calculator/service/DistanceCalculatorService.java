package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.service.model.Point;
import com.woodwing.distance.calculator.exception.DistanceException;
import com.woodwing.distance.calculator.convertor.manager.ConvertorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to calculate distance.
 */
@Service
public class DistanceCalculatorService {

    @Autowired
    private ConvertorManager convertorManager;

    /**
     * Calculate distance with given {@code pointA} ,{@code pointB} in the specified distance unit  {@code toDistance}
     *
     * @param pointA expected this to be not null
     * @param pointB expected this to be not null
     * @param toDistance expected this to be not null
     * @return returns the distance with unit. e.g: 37.5 Meters.
     * @throws DistanceException on error
     */
    public String calculateDistance(Point pointA, Point pointB, DistanceUnit toDistance) throws DistanceException {
        Point point = calculatorDistance(pointA, pointB, toDistance);
        return point.getDistance() + " " + point.getUnit().toString();
    }

    private Point calculatorDistance(Point pointA, Point pointB, DistanceUnit toType) throws DistanceException {
        double distance1 = convertorManager.getConverted(pointA.getDistance(), pointA.getUnit(), toType);
        double distance2 = convertorManager.getConverted(pointB.getDistance(), pointB.getUnit(), toType);
        double distance = distance1 + distance2;

        return new Point(distance, toType);
    }
}
