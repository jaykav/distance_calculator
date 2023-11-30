package com.woodwing.distance.calculator.controller.model;

import com.woodwing.distance.calculator.service.DistanceUnit;

public class DistanceRequestModel {

    private Point pointA;

    private Point pointB;

    private DistanceUnit responseDistanceUnit;

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public DistanceUnit getResponseDistanceUnit() {
        return responseDistanceUnit;
    }

    public void setResponseDistanceUnit(DistanceUnit responseDistanceUnit) {
        this.responseDistanceUnit = responseDistanceUnit;
    }

    public DistanceRequestModel() {
    }

    private class Point {
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
}
