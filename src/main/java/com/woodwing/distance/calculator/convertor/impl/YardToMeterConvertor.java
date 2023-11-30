package com.woodwing.distance.calculator.convertor.impl;

import com.woodwing.distance.calculator.convertor.IUnitConvertor;

public class YardToMeterConvertor implements IUnitConvertor {

    public double convert(double yardDistance) {
        return yardDistance * 0.9144;
    }
}
