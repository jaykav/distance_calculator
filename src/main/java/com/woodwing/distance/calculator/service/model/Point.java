package com.woodwing.distance.calculator.service.model;

import com.woodwing.distance.calculator.service.DistanceUnit;

public class Point {
    private double distance;
    private DistanceUnit unit;

    public Point(){}

    public Point(double distance, DistanceUnit unit) {
        this.distance = distance;
        this.unit = unit;
    }

    public double getDistance() {
        return distance;
    }

    public DistanceUnit getUnit() {
        return unit;
    }
}
