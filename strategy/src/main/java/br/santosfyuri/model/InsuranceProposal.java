package br.santosfyuri.model;

public class InsuranceProposal {

    private Client client;
    private InsuranceCalculator calculator;

    public InsuranceProposal(Client client) {
        this.client = client;
    }

    public String generate(double vehicleValue) {
        StringBuilder proposal = new StringBuilder();

        proposal.append("\n================================================")
                .append("\nInsurance Proposal\n")
                .append("\nClient: " + this.client.getName())
                .append("\nAge: " + this.client.getAge())
                .append("\nGender: " + this.client.getGender().getDescription())
                .append("\nInsurance value : " + Math.round(calculator.clientCalculate(client, vehicleValue)))
                .append("\n================================================");
        return proposal.toString();
    }

    public void setCalculator(InsuranceCalculator calculator) {
        this.calculator = calculator;
    }
}
