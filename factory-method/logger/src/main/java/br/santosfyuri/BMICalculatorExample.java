package br.santosfyuri;

import br.santosfyuri.textfile.TextFileCreator;

import java.util.Scanner;

public class BMICalculatorExample {

    private Logger logger;

    BMICalculatorExample(Logger logger) {
        this.logger = logger;
    }

    public void calculate() {
        System.out.println("Digite algo :");

        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();

        if (between(value, null, 18.5)) {
            logger.log("Abaixo do peso normal");
        } else if (between(value, 18.5, 24.9)) {
            logger.log("Peso normal");
        } else if (between(value, 25.0, 29.9)) {
            logger.log("Excesso de peso");
        } else if (between(value, 30.0, 34.9)) {
            logger.log("Obesidade classe I");
        } else if (between(value, 35.0, 39.9)) {
            logger.log("Obesidade classe II");
        } else if (between(value, 40.0, null)) {
            logger.log("Obesidade classe III");
        }
    }

    private boolean between(Double value, Double min, Double max) {
        if (min == null) {
            return value <= max;
        }
        if (max == null) {
            return value >= min;
        }
        return value >= min && value <= max;
    }

    public static void main(String[] args) {
        TextFileCreator creator = new TextFileCreator("logs.txt");
        BMICalculatorExample bmiCalculatorExample = new BMICalculatorExample(creator);
        bmiCalculatorExample.calculate();
    }
}
