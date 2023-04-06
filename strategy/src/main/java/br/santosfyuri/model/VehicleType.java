package br.santosfyuri.model;

public enum VehicleType {

    CAR {
        @Override
        public InsuranceCalculator getInsuranceCalculator() {
            return new InsuranceCarCalculator();
        }
    },
    MOTORCYCLE {
        @Override
        public InsuranceCalculator getInsuranceCalculator() {
            return new InsuranceMotorcyleCalculator();
        }
    };

    public abstract InsuranceCalculator getInsuranceCalculator();
}
