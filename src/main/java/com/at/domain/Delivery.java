package com.at.domain;

import java.util.List;

public class Delivery {
    List<Order> orders;

    public Delivery(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return List.copyOf(orders);
    }

    public Delivery addOrder(Order order) {
        List<Order> newOrders = this.orders;
        newOrders.add(order);
        return new Delivery(newOrders);
    }
}
