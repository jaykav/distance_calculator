package com.woodwing.distance.calculator.convertor.manager;

import com.woodwing.distance.calculator.service.DistanceUnit;
import com.woodwing.distance.calculator.exception.DistanceException;
import com.woodwing.distance.calculator.convertor.impl.MeterToYardConvertor;
import com.woodwing.distance.calculator.convertor.impl.YardToMeterConvertor;
import org.springframework.stereotype.Service;

@Service
public class ConvertorManager {

    public double getConverted(double distance, DistanceUnit from, DistanceUnit to) throws DistanceException {
        if (from.equals(to)) return distance;

        if (from.equals(DistanceUnit.METER) && to.equals(DistanceUnit.YARD)) {
             return new MeterToYardConvertor().convert(distance);
        }

        if (from.equals(DistanceUnit.YARD) && to.equals(DistanceUnit.METER)) {
            return new YardToMeterConvertor().convert(distance);
        }

        throw new DistanceException("No convertor from " + from + " to: " + to);
    }
}
