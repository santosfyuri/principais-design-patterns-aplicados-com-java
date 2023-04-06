package br.santosfyuri.model;

import java.util.Scanner;

public class InsuranceExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        InsuranceProposal proposal;
        VehicleType vehicleType;
        double vehicleValue;

        System.out.print("Client name:\t");
        client.setName(scanner.nextLine());

        System.out.print("Age:\t");
        client.setAge(scanner.nextInt());

        System.out.print("Gender [1 - Male] [2 - Female] [3 - Others]:\t");
        client.setGender(Gender.values()[scanner.nextInt() - 1]);

        System.out.print("Vehicle [1 - Car] [2 - Motorcycle]:\t");
        vehicleType = VehicleType.values()[scanner.nextInt()-1];

        System.out.print("Value:\t");
        vehicleValue = scanner.nextDouble();

        proposal = new InsuranceProposal(client);
        proposal.setCalculator(vehicleType.getInsuranceCalculator());

        System.out.println(proposal.generate(vehicleValue));
    }
}
