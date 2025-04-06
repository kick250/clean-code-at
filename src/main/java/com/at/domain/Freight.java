package com.at.domain;

public class Freight {
    protected void validateWeight(double weight) {
        if (weight < 0) throw new IllegalArgumentException("O peso não pode ser negativo");
    }
}
