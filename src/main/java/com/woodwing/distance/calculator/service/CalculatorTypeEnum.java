package com.woodwing.distance.calculator.service;

public enum CalculatorTypeEnum {

    YARD("YARD"), METER("METER");

    private final String abbreviation;

    CalculatorTypeEnum(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    // Helper method to find enum by string value
    public static CalculatorTypeEnum findByAbbreviation(String abbreviation) {
        for (CalculatorTypeEnum size : CalculatorTypeEnum.values()) {
            if (size.abbreviation.equals(abbreviation)) {
                return size;
            }
        }
        // If no match is found, return null or throw an exception as needed
        return null;
    }
}