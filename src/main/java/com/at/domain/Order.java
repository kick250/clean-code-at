package com.at.domain;

public class Order {
    private String address;
    private double weight;
    private FreightType freightType;
    private String recipient;

    public Order(String address, double weight, FreightType freightType, String recipient) {
        this.address = address;
        this.weight = weight;
        this.freightType = freightType;
        this.recipient = recipient;
    }

    public String getAddress() {
        return address;
    }

    public double getWeight() {
        return weight;
    }

    public FreightType getFreightType() {
        return freightType;
    }

    public String getFreightTypeName() {
        return freightType.getFreightName();
    }

    public String getRecipient() {
        return recipient;
    }

    public void applyFreightDiscount() {
        if (weight > 10) {
            weight = weight - 1;
        }
    }

    public boolean isFreeFreight() {
        return freightType.equals("ECO") && weight < 2;
    }
}