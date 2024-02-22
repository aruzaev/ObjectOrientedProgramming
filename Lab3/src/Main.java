import java.util.Scanner;
import java.text.DecimalFormat;

// This class manages the hardware store operations
class HardwareManager {
    // Constants for prices, they will never change
    private final int BOLT_PRICE = 6; // 0.06 dollars in cents
    private final int NUT_PRICE = 4;  // 0.04 dollars in cents
    private final int WASHER_PRICE = 2; // 0.02 dollars in cents

    // Data points for the amount of hardware person will buy
    private int bolts;
    private int nuts;
    private int washers;

    // Getter and setter methods for the number of bolts
    public int getBolts() {
        return bolts;
    }

    public void setBolts(int bolts) {
        this.bolts = bolts;
    }

    // Getter and setter methods for the number of nuts
    public int getNuts() {
        return nuts;
    }

    public void setNuts(int nuts) {
        this.nuts = nuts;
    }

    // Getter and setter methods for the number of washers
    public int getWashers() {
        return washers;
    }

    public void setWashers(int washers) {
        this.washers = washers;
    }

    // Method to get user input for the number of each hardware item
    public void getHardwareInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of bolts: ");
        setBolts(scanner.nextInt());

        System.out.print("Number of nuts: ");
        setNuts(scanner.nextInt());

        System.out.print("Number of washers: ");
        setWashers(scanner.nextInt());
    }

    // Method to calculate the total cost of the hardware items
    public int calculateTotalCostInCents() {
        return (getBolts() * BOLT_PRICE) + (getNuts() * NUT_PRICE) + (getWashers() * WASHER_PRICE);
    }

    // Method to check if the order is correct
    public void checkOrder() {
        if (getNuts() < getBolts()) {
            System.out.println("Check the Order: too few nuts");
        }

        if (getWashers() < (getBolts() * 2)) {
            System.out.println("Check the Order: too few washers");
        }

        if (getNuts() >= getBolts() && getWashers() >= (getBolts() * 2)) {
            System.out.println("Order is OK");
        }
    }

    // Method to display the total cost of the hardware items
    public void displayTotalCost() {
        System.out.println("Total cost: " + calculateTotalCostInCents());
    }
}

public class Main {
    public static void main(String[] args) {
        HardwareManager hardwareManager = new HardwareManager();
        hardwareManager.getHardwareInput();
        hardwareManager.checkOrder();
        hardwareManager.displayTotalCost();
    }
}
