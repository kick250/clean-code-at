package com.at.services;

import com.at.domain.Order;
import com.at.interfaces.FreightCalculator;

public class SampleService {
    private FreightCalculator freightCalculator;
    private Order order;

    public static SampleService build(Order order) {
        FreightCalculator freightCalculator = order.getFreightType().getCalculator();

        return new SampleService(freightCalculator, order);
    }

    public SampleService(FreightCalculator freightCalculator, Order order) {
        this.freightCalculator = freightCalculator;
        this.order = order;
    }

    public String generateSample() {
        return "Destinatário: " + order.getRecipient() + "\nEndereço: " + order.getAddress() + "\nValor do Frete: R$" + calculateFreight();
    }

    public String generateOrderSummary() {
        return "Pedido para " + order.getRecipient() + " com frete tipo " + order.getFreightTypeName() + " no valor de R$" + calculateFreight();
    }

    private double calculateFreight() {
        return freightCalculator.calculateFreight(order);
    }
}
