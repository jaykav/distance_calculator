package com.woodwing.distance.calculator.model;

public class RequestPointModel {
    private double distance;
    private String unit;

    public RequestPointModel(){}

    public RequestPointModel(double distance, String unit) {
        this.distance = distance;
        this.unit = unit;
    }

    public double getDistance() {
        return distance;
    }

    public String getUnit() {
        return unit;
    }
}
