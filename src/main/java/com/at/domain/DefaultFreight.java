package com.at.domain;

import com.at.interfaces.FreightCalculator;

public class DefaultFreight implements FreightCalculator {
    private static final double FREIGHT_MULTIPLIER = 1.2;

    @Override
    public double calculateFreight(Order order) {
        return order.getWeight() * FREIGHT_MULTIPLIER;
    }
}
