package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.exception.DistanceException;
import com.woodwing.distance.calculator.service.model.Point;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DistanceCalculatorServiceTest {

    @Autowired
    private DistanceCalculatorService distanceCalculatorService;

    @Test
    public void testMeterToYard() throws Exception{

        Point pointA = new Point(5, DistanceUnit.METER);
        Point pointB = new Point(1, DistanceUnit.METER);

        String value = distanceCalculatorService.calculateDistance(pointA, pointB, DistanceUnit.YARD);

        assertTrue(value.contains("6.56166"));
        assertTrue(value.contains(DistanceUnit.YARD.toString()));
    }

    @Test
    public void testMeterToMeter() throws Exception {

        Point pointA = new Point(5, DistanceUnit.METER);
        Point pointB = new Point(1, DistanceUnit.METER);

        String value = distanceCalculatorService.calculateDistance(pointA, pointB, DistanceUnit.METER);

        assertTrue(value.contains("6.0"));
        assertTrue(value.contains(DistanceUnit.METER.toString()));
    }

    @Test
    public void testMeterYardToMeter() throws Exception {

        Point pointA = new Point(5, DistanceUnit.METER);
        Point pointB = new Point(1, DistanceUnit.YARD);

        String value = distanceCalculatorService.calculateDistance(pointA, pointB, DistanceUnit.METER);

        assertTrue(value.contains("5.9144"));
        assertTrue(value.contains(DistanceUnit.METER.toString()));
    }

    @Test
    public void testYardMeterToMeter() throws Exception {

        Point pointA = new Point(5, DistanceUnit.YARD);
        Point pointB = new Point(1, DistanceUnit.METER);

        String value = distanceCalculatorService.calculateDistance(pointA, pointB, DistanceUnit.METER);

        assertTrue(value.contains("5.572"));
        assertTrue(value.contains(DistanceUnit.METER.toString()));
    }

    @Test
    public void testYardToYard() throws Exception {

        Point pointA = new Point(5, DistanceUnit.YARD);
        Point pointB = new Point(1, DistanceUnit.YARD);

        String value = distanceCalculatorService.calculateDistance(pointA, pointB, DistanceUnit.YARD);

        assertTrue(value.contains("6.0"));
        assertTrue(value.contains(DistanceUnit.YARD.toString()));
    }

    @Test
    public void testUnknownDistance() throws Exception {

        Point pointA = new Point(5, null);
        Point pointB = new Point(1, DistanceUnit.YARD);

        DistanceException exception = assertThrows(DistanceException.class, () -> {
            distanceCalculatorService.calculateDistance(pointA, pointB, DistanceUnit.YARD);
        });

        String expectedMessage = "Undefined distance unit!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}