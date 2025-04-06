package com.at.domain;

import com.at.interfaces.FreightCalculator;

public class ExpressFreight extends Freight implements FreightCalculator {
    private static final double FREIGHT_MULTIPLIER = 1.5;
    private static final double EXPRESS_FEE = 10;


    @Override
    public double calculateFreight(Order order) {
        validateWeight(order.getWeight());

        return order.getWeight() * FREIGHT_MULTIPLIER + EXPRESS_FEE;
    }
}
