package com.at.domain;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private String address;
    private double weight;
    private FreightType freightType;
    private String recipient;

    @BeforeEach
    void setUp() {
        Faker faker = Faker.instance();

        address = faker.address().fullAddress();
        weight = faker.number().randomDouble(2, 0, 100);
        freightType = FreightType.DEFAULT;
        recipient = faker.name().fullName();
    }

    @Test
    public void constructor_whenAllArgumentsAreValid() {
        assertDoesNotThrow(() -> { new Order(address, weight, freightType, recipient); });
    }

    @Test
    public void constructor_whenAddressIsInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { new Order(null, weight, freightType, recipient); });

        assertEquals("O endereço não pode estar vazio.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> { new Order("", weight, freightType, recipient); });

        assertEquals("O endereço não pode estar vazio.", exception.getMessage());
    }

    @Test
    public void constructor_whenWeightIsInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { new Order(address, -1.0, freightType, recipient); });

        assertEquals("O peso deve ser maior que zero.", exception.getMessage());
    }

    @Test
    public void constructor_whenFreightTypeIsInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { new Order(address, weight, null, recipient); });

        assertEquals("O tipo de frete não deve ser nulo.", exception.getMessage());
    }

    @Test
    public void constructor_whenRecipientIsInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { new Order(address, weight, freightType, null); });

        assertEquals("O destinatário não pode estar vazio.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> { new Order(address, weight, freightType, ""); });

        assertEquals("O destinatário não pode estar vazio.", exception.getMessage());
    }
}
