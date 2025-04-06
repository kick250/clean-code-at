package com.at.domain;

import com.at.interfaces.FreightCalculator;

public class EconomicFreight implements FreightCalculator {
    private static final double FREIGHT_MULTIPLIER = 1.1;
    private static final double ECONOMIC_DISCOUNT = 5;

    @Override
    public double calculateFreight(Order order) {
        return order.getWeight() * FREIGHT_MULTIPLIER - ECONOMIC_DISCOUNT;
    }
}
