package com.at.domain;

public class Order {
    private static final int MIN_WEIGHT_TO_DISCOUNT = 10;
    private static final int MAX_WEIGHT_TO_FREE_FREIGHT = 2;

    private String address;
    private double weight;
    private FreightType freightType;
    private String recipient;
    private boolean freightDiscountApplied = false;

    public Order(String address, double weight, FreightType freightType, String recipient) {
        if (address == null || address.isBlank())
            throw new IllegalArgumentException("O endereço não pode estar vazio.");
        if (weight < 0)
            throw new IllegalArgumentException("O peso deve ser maior que zero.");
        if (freightType == null)
            throw new IllegalArgumentException("O tipo de frete não deve ser nulo.");
        if (recipient == null || recipient.isBlank())
            throw new IllegalArgumentException("O destinatário não pode estar vazio.");

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
        if (freightDiscountApplied) return;

        if (weight > MIN_WEIGHT_TO_DISCOUNT) {
            weight = weight - 1;
            freightDiscountApplied = true;
        }
    }

    public boolean isFreeFreight() {
        return freightType.isEconomic() && weight < MAX_WEIGHT_TO_FREE_FREIGHT;
    }
}