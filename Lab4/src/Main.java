class Lab4 {
    //  add integers that are multiples of 3 or 5 up to a certain limit
    public void addInt() {
        int i = 0; // start counting from 0
        int sum = 0; // this will hold the sum of the multiples
        int limit = 10; // we stop when we reach this limit

        // keep looping until i is greater than the limit
        while (i <= limit) {
            i++; // increment i by 1 each time through the loop
            // if i is a multiple of 3 or 5, add it to the sum
            if (i % 3 == 0 || i % 5 == 0) {
                sum = sum + i;
            }
        }
        // print the final sum
        System.out.println(sum);
    }

    // prints a multiplication table for 6 and sum
    public void multiply6() {
        int numberTable = 6; // we're working with the 6 times table
        int sum = 0; // this will hold our special sum
        int i = 1; // start with the first multiplier

        // loop through the first 10 multipliers
        while (i <= 10) {
            // print out each step of the multiplication table
            System.out.println(numberTable + " * " + i + "=" + numberTable * i);
            // if the product is positive and not greater than 20, add it (and a bit more) to the sum
            if ((numberTable * i > 0) && (numberTable * i <= 20)) {
                sum = sum + (numberTable * i) + i / 2;
            }

            i++; // move to the next multiplier
        }

        // check if the sum is even or odd and print the result
        if ((sum % 2) == 0) {
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
    }

    // prints a pyramid of asterisks
    public void pyramid() {
        String outputStr = ""; // this will hold our pyramid
        int a = 10; // the height of the pyramid

        // build the pyramid from top to bottom
        while (a > 0) {
            // add a line of asterisks to the pyramid
            for (int i = 1; i <= a; i++) {
                outputStr = outputStr + " " + "*";
            }
            outputStr += "\n"; // move to the next line
            a--; // decrease the height for the next iteration
        }

        // print the complete pyramid
        System.out.println(outputStr);
    }
}

public class Main {
    public static void main(String[] args) {
        Lab4 lab4 = new Lab4();
        // create an instance of Lab4 and call its methods to perform the tasks
        lab4.addInt(); // adds integers that are multiples of 3 or 5
        lab4.multiply6(); // prints a multiplication table for 6 and sums certain products
        lab4.pyramid(); // prints a pyramid of asterisks
    }
}
