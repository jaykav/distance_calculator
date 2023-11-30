package com.woodwing.distance.calculator.service;

import com.woodwing.distance.calculator.exception.DistanceException;

/**
 * Supported distance conversion units.
 */
public enum DistanceUnit {

    YARD("YARD"), METER("METER");

    private final String abbreviation;

    DistanceUnit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Helper method to find enum by string value
     */
    public static DistanceUnit findByAbbreviation(String abbreviation) throws DistanceException {
        if (abbreviation == null || abbreviation.isEmpty()){
            throw new DistanceException("Undefined unit!");
        }

        abbreviation = abbreviation.toUpperCase();

        for (DistanceUnit size : DistanceUnit.values()) {
            if (size.abbreviation.equals(abbreviation)) {
                return size;
            }
        }
        // If no match is found, return null or throw an exception as needed
        throw new DistanceException("Unsupported unit [" + abbreviation + "]");
    }
}