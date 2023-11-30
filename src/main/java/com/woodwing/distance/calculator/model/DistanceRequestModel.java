package com.woodwing.distance.calculator.model;


public class DistanceRequestModel {

    private RequestPointModel pointA;

    private RequestPointModel pointB;

    private String responseDistanceUnit;

    public DistanceRequestModel() {
    }

    public RequestPointModel getPointA() {
        return pointA;
    }

    public void setPointA(RequestPointModel pointA) {
        this.pointA = pointA;
    }

    public RequestPointModel getPointB() {
        return pointB;
    }

    public void setPointB(RequestPointModel pointB) {
        this.pointB = pointB;
    }

    public String getResponseDistanceUnit() {
        return responseDistanceUnit;
    }

    public void setResponseDistanceUnit(String responseDistanceUnit) {
        this.responseDistanceUnit = responseDistanceUnit;
    }
}
