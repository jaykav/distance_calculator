package com.woodwing.distance.calculator.convertor.impl;

import com.woodwing.distance.calculator.convertor.IUnitConvertor;

public class MeterToYardConvertor implements IUnitConvertor {

    public double convert(double meterDistance) {
        return meterDistance * 1.09361;
    }
}
