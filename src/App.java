import java.util.Scanner;

/**
 * Calculator App
 * 
 * Objective: Refresh on user input and basic operations
 * Tasks: To create a simple calculator that takes two numbers and an operator
 * (+, -, *, /) as input and prints the result
 */
public class App {

    /**
     * Simple method to take in 2 numerical inputs and an operator
     */
    public static double calculator(double num1, double num2, char operator) {
        switch(operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*': 
                return num1 * num2;
            case '/':
                if(num1 == 0 || num2 == 0) {
                    return 0;
                } else {
                    return num1 / num2;
                }
            default:
                throw new IllegalArgumentException();

        }
    }

    /**
     * Method to parse a given string for numbers and operators
     */
    public static void calculator(String input) 
    
        // This uses a regular expression to split the input string at the boundary 
        // between a non-digit (\\D) and a digit (\\d). The (?<=...) and (?=...) are 
        // lookbehind and lookahead assertions, respectively. They make the split happen 
        // before or after the match, without consuming the match.
        String[] tokens = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");    
    }

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        System.out.println("The calculator only takes two numbers and an operator");
        
        System.out.println("Enter the first number: ");
        double num1 = input.nextDouble();

        System.out.println("Enter the operator: ");
        char operator = input.next().charAt(0);

        System.out.println("Enter the second number: ");
        double num2 = input.nextDouble();

        System.out.println("Results: " + calculator(num1, num2, operator));
    }
}
