
import java.util.Scanner;

class TaxCalculator {
    // federal tax brackets and rates
    private final double FEDERAL_BRACKET1 = 53359.00;
    private final double FEDERAL_BRACKET2 = 106717.00;
    private final double FEDERAL_BRACKET3 = 165430.00;
    private final double FEDERAL_BRACKET4 = 235675.00;
    private final double FEDERAL_RATE1 = 0.15;
    private final double FEDERAL_RATE2 = 0.205;
    private final double FEDERAL_RATE3 = 0.26;
    private final double FEDERAL_RATE4 = 0.29;
    private final double FEDERAL_RATE5 = 0.33;

    // Ontario tax brackets and rates
    private final double ONTARIO_BRACKET1 = 49231.00;
    private final double ONTARIO_BRACKET2 = 98463.00;
    private final double ONTARIO_BRACKET3 = 150000.00;
    private final double ONTARIO_BRACKET4 = 220000.00;
    private final double ONTARIO_RATE1 = 0.0505;
    private final double ONTARIO_RATE2 = 0.0915;
    private final double ONTARIO_RATE3 = 0.1116;
    private final double ONTARIO_RATE4 = 0.1216;
    private final double ONTARIO_RATE5 = 0.1316;

    // CPP
    private final double CPP_CONTRIBUTION_LIMIT = 66600.00;
    private final double CPP_EXEMPTION = 3500.00;
    private final double CPP_RATE = 0.0595;

    // EI
    private final double EI_RATE = 0.0163;
    private final double MAX_EI_EARNINGS = 61500.00;

    public double calculateFederalTax(double salary) {
        double tax = 0.0;
        // Calculate tax for each bracket
        if (salary <= FEDERAL_BRACKET1) {
            tax = salary * FEDERAL_RATE1;
        } else if (salary <= FEDERAL_BRACKET2) {
            tax = FEDERAL_BRACKET1 * FEDERAL_RATE1 +
                    (salary - FEDERAL_BRACKET1) * FEDERAL_RATE2;
        } else if (salary <= FEDERAL_BRACKET3) {
            tax = FEDERAL_BRACKET1 * FEDERAL_RATE1 +
                    (FEDERAL_BRACKET2 - FEDERAL_BRACKET1) * FEDERAL_RATE2 +
                    (salary - FEDERAL_BRACKET2) * FEDERAL_RATE3;
        } else if (salary <= FEDERAL_BRACKET4) {
            tax = FEDERAL_BRACKET1 * FEDERAL_RATE1 +
                    (FEDERAL_BRACKET2 - FEDERAL_BRACKET1) * FEDERAL_RATE2 +
                    (FEDERAL_BRACKET3 - FEDERAL_BRACKET2) * FEDERAL_RATE3 +
                    (salary - FEDERAL_BRACKET3) * FEDERAL_RATE4;
        } else {
            tax = FEDERAL_BRACKET1 * FEDERAL_RATE1 +
                    (FEDERAL_BRACKET2 - FEDERAL_BRACKET1) * FEDERAL_RATE2 +
                    (FEDERAL_BRACKET3 - FEDERAL_BRACKET2) * FEDERAL_RATE3 +
                    (FEDERAL_BRACKET4 - FEDERAL_BRACKET3) * FEDERAL_RATE4 +
                    (salary - FEDERAL_BRACKET4) * FEDERAL_RATE5;
        }

        return tax;
    }

    // Calculate Ontario provincial tax based on salary and tax brackets
    public double calculateOntarioTax(double salary) {
        double tax = 0.0;
        // Similar calculation as federal tax, but using Ontario brackets and rates
        if (salary <= ONTARIO_BRACKET1) {
            tax = salary * ONTARIO_RATE1;
        } else if (salary <= ONTARIO_BRACKET2) { // if within bracket 2 take
            tax = ONTARIO_BRACKET1 * ONTARIO_RATE1 + (salary - ONTARIO_BRACKET1) * ONTARIO_RATE2;
        } else if (salary <= ONTARIO_BRACKET3) {
            tax = ONTARIO_BRACKET1 * ONTARIO_RATE1 +
                    (ONTARIO_BRACKET2 - ONTARIO_BRACKET1) * ONTARIO_RATE2 + (salary - ONTARIO_BRACKET2) * ONTARIO_RATE3;
        } else if (salary <= ONTARIO_BRACKET4) {
            tax = ONTARIO_BRACKET1 * ONTARIO_RATE1 + (ONTARIO_BRACKET2 - ONTARIO_BRACKET1) * ONTARIO_RATE2 +
                    (ONTARIO_BRACKET3 - ONTARIO_BRACKET2) * ONTARIO_RATE3 + (salary - ONTARIO_BRACKET3) * ONTARIO_RATE4;
        } else {
            tax = ONTARIO_BRACKET1 * ONTARIO_RATE1 +
                    (ONTARIO_BRACKET2 - ONTARIO_BRACKET1) * ONTARIO_RATE2 + (ONTARIO_BRACKET3 - ONTARIO_BRACKET2) * ONTARIO_RATE3 +
                    (ONTARIO_BRACKET4 - ONTARIO_BRACKET3) * ONTARIO_RATE4 + (salary - ONTARIO_BRACKET4) * ONTARIO_RATE5;
        }

        return tax;
    }

    // Calculate CPP contributions based on salary
    public double calculateCPP(double salary) {
        double cppContribution = 0.0;
        if (salary > CPP_EXEMPTION) {
            double cppDeductibleSalary = salary - CPP_EXEMPTION;
            cppContribution = cppDeductibleSalary * CPP_RATE;
            if (cppContribution > ((CPP_CONTRIBUTION_LIMIT - CPP_EXEMPTION) * CPP_RATE)) {
                cppContribution = (CPP_CONTRIBUTION_LIMIT - CPP_EXEMPTION) * CPP_RATE;
            }
        }
        return cppContribution;
    }
    // Calculate EI contributions based on salary

    public double calculateEI(double salary) {
        double eiContribution = salary * EI_RATE;
        if (salary > MAX_EI_EARNINGS) {
            eiContribution = MAX_EI_EARNINGS * EI_RATE;
        }
        return eiContribution;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your salary: ");
        double salary = scanner.nextDouble();

        TaxCalculator calculator = new TaxCalculator();

        double federalTax = calculator.calculateFederalTax(salary);
        double ontarioTax = calculator.calculateOntarioTax(salary);
        double cpp = calculator.calculateCPP(salary);
        double ei = calculator.calculateEI(salary);
        double totalDeductions = federalTax + ontarioTax + cpp + ei;
        double netSalary = salary - totalDeductions;

        System.out.printf("Total Federal Tax Deduction: %.2f%n", federalTax);
        System.out.printf("Total Ontario Tax Deduction: %.2f%n", ontarioTax);
        System.out.printf("Total EI deduction: %.2f%n", ei);
        System.out.printf("Total CPP deduction: %.2f%n", cpp);
        System.out.printf("Total Net Salary after deductions: %.2f%n", netSalary);
    }
}
