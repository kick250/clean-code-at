package com.at.domain;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class DeliveryTest {
    private Delivery delivery;
    private List<Order> orders;
    private Order newOrder;

    @BeforeEach
    public void setUp() {
        Faker faker = Faker.instance();

        orders = new ArrayList<>();
        orders.add(new Order(faker.address().fullAddress(), faker.number().randomDouble(2, 0, 100), FreightType.DEFAULT, faker.name().fullName()));
        orders.add(new Order(faker.address().fullAddress(), faker.number().randomDouble(2, 0, 100), FreightType.DEFAULT, faker.name().fullName()));
        newOrder = new Order(faker.address().fullAddress(), faker.number().randomDouble(2, 0, 100), FreightType.DEFAULT, faker.name().fullName());

        delivery = new Delivery(orders);
    }

    @AfterEach
    public void tearDown() {
        orders = null;
        delivery = null;
    }


    @Test
    public void testAddOrder() {
        assertEquals(orders.size(), delivery.getOrders().size());

        Delivery newDelivery = delivery.addOrder(newOrder);

        assertEquals(orders.size(), delivery.getOrders().size());
        assertEquals(3, newDelivery.getOrders().size());
    }
}
