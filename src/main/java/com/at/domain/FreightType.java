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

        @Override
        public boolean isEconomic() {
            return false;
        }
    },
    ECONOMIC() {
        @Override
        public String getFreightName() {
            return "ECO";
        }

        @Override
        public FreightCalculator getCalculator() {
            return new EconomicFreight();
        }

        @Override
        public boolean isEconomic() {
            return true;
        }
    },
    EXPRESS() {
        @Override
        public String getFreightName() {
            return "EXP";
        }

        @Override
        public FreightCalculator getCalculator() {
            return new ExpressFreight();
        }

        @Override
        public boolean isEconomic() {
            return false;
        }
    };

    public abstract String getFreightName();

    public abstract FreightCalculator getCalculator();

    public abstract boolean isEconomic();
}
