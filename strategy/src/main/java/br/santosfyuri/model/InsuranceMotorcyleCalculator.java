package br.santosfyuri.model;

public class InsuranceMotorcyleCalculator implements InsuranceCalculator {
    @Override
    public double clientCalculate(Client client, double vehicleValue) {
        double tax = client.getAge() >= 18 && client.getAge() <= 30 ? 0.05 : 0.045;
        return vehicleValue * tax;
    }
}
