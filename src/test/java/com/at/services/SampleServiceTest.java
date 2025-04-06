package com.at.services;

import com.at.domain.FreightType;
import com.at.domain.Order;
import com.at.interfaces.FreightCalculator;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleServiceTest {
    private FreightCalculator freightCalculator;
    private Order order;
    private String recipient;
    private String address;
    private String freightTypeName;
    private double freightValue;

    @BeforeEach
    public void setUp() {
        freightCalculator = Mockito.mock(FreightCalculator.class);
        order = Mockito.mock(Order.class);

        recipient = Faker.instance().name().fullName();
        address = Faker.instance().address().fullAddress();
        freightTypeName = FreightType.DEFAULT.getFreightName();
        freightValue = 100.0;

        Mockito.when(order.getRecipient()).thenReturn(recipient);
        Mockito.when(order.getAddress()).thenReturn(address);
        Mockito.when(order.getFreightTypeName()).thenReturn(freightTypeName);

        Mockito.when(freightCalculator.calculateFreight(order)).thenReturn(freightValue);
    }

    @Test
    public void generateSample() {
        SampleService sampleService = new SampleService(freightCalculator, order);

        String expectedMessage = "Destinatário: " + recipient + "\nEndereço: " + address + "\nValor do Frete: R$" + freightValue;
        assertEquals(expectedMessage, sampleService.generateSample());
    }

    @Test
    public void generateOrderSummary() {
        SampleService sampleService = new SampleService(freightCalculator, order);

        String expectedMessage = "Pedido para " + recipient + " com frete tipo " + freightTypeName + " no valor de R$" + freightValue;
        assertEquals(expectedMessage, sampleService.generateOrderSummary());
    }
}
