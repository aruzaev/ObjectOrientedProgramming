// Artem Ruzaev
// n01497403
// Lab # 1

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Defines the scanner object

        System.out.print("Please enter the first number: ");
        int num1 = scan.nextInt(); // receives input for the first number

        System.out.print("Please enter the second number: ");
        int num2 = scan.nextInt(); // receives input for the second number

        int answer = num1 + num2; // adds the first and second number and saves it under a newly declared variable called answer
        System.out.println(answer);

        answer = num1 - num2; // subtracts the first and second number and resets the variable answer value
        System.out.println(answer);

        answer = num1 * num2; // multiply the first and second number and resets the variable answer value
        System.out.println(answer);

        answer = num1 / num2; // throwing away the remainder because it is an integer
        System.out.println(answer);

        answer = num1 % num2; // gets the remainder of dividing num1 and num2 and stores it in answer
        System.out.println(answer);

        answer = ++num1; // pre-incrementing the first number so number updates when printed in the following line
        System.out.println(answer);
        answer = ++num2; // pre-incrementing the second number so number updates when printed in the following line
        System.out.println(answer);

        double double1 = scan.nextDouble(); // initializing doubles and getting inputs for the double
        double double2 = scan.nextDouble();

        double answerDouble = double1 / double2; // initializes a double variable for the answer and sets it to the division result of the first and second number
        System.out.println(answerDouble);

        answerDouble = Math.round(double1 / double2); // rounding the quotient using the builtin Math library with the round() function
        System.out.println(answerDouble);

        answerDouble = Math.pow(double1, 3); // cubing the first number using the builtin Math library with the pow() function
        System.out.println(answerDouble);

        answerDouble = Math.sqrt(double2); // square rooting the second number using the builtin Math library with the sqrt() function
        System.out.println(answerDouble);

    }
}