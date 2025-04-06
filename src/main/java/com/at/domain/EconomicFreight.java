package com.at.domain;

import com.at.interfaces.FreightCalculator;

public class EconomicFreight implements FreightCalculator {

    @Override
    public double calculateFreight(Order order) {
        return order.getWeight() * 1.1 - 5;
    }
}
