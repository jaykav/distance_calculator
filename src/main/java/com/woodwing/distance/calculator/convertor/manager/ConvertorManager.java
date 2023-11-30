package com.woodwing.distance.calculator.convertor.manager;

import com.woodwing.distance.calculator.service.DistanceUnit;
import com.woodwing.distance.calculator.exception.DistanceException;
import com.woodwing.distance.calculator.convertor.impl.MeterToYardConvertor;
import com.woodwing.distance.calculator.convertor.impl.YardToMeterConvertor;
import org.springframework.stereotype.Service;

/**
 * Manages different types of convertors.
 */
@Service
public class ConvertorManager {

    /**
     * Converts given {@code distance} from {@code from} to {@code to} distance unit.
     *
     * @param distance value to be converted
     * @param from the current given {@code distance} value unit
     * @param to the unit to be converted
     * @return new converted value
     * @throws DistanceException on error
     */
    public double getConverted(double distance, DistanceUnit from, DistanceUnit to) throws DistanceException {
        if (from == null || to == null) throw new DistanceException("Undefined distance unit!");
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
