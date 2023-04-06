package br.santosfyuri.model;

public class InsuranceCarCalculator implements InsuranceCalculator {
    @Override
    public double clientCalculate(Client client, double vehicleValue) {
        return (client.getAge() >= 50) ? vehicleValue * 0.04 : vehicleValue * 0.03;
    }
}
