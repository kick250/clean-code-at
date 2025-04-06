package com.at.domain;

import com.at.interfaces.FreightCalculator;

public class ExpressFreight extends Freight implements FreightCalculator {

    @Override
    public double calculateFreight(Order order) {
        validateWeight(order.getWeight());

        return order.getWeight() * 1.5 + 10;
    }
}
