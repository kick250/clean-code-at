package com.at.domain;

import com.at.interfaces.FreightCalculator;

public enum FreightType {
    DEFAULT() {
        @Override
        public String getFreightName() {
            return "PAD";
        }

        @Override
        public FreightCalculator getCalculator() {
            return new DefaultFreight();
        }
    },
    ECONOMIC {
        @Override
        public String getFreightName() {
            return "ECO";
        }

        @Override
        public FreightCalculator getCalculator() {
            return new EconomicFreight();
        }
    },
    EXPRESS {
        @Override
        public String getFreightName() {
            return "EXP";
        }

        @Override
        public FreightCalculator getCalculator() {
            return new ExpressFreight();
        }
    };

    public abstract String getFreightName();

    public abstract FreightCalculator getCalculator();
}
