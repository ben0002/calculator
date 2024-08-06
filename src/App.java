import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

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
     * Method to parse a string input for calculations using the Shunting Yard Algorithm 
     */
    public static double calculator(String input) {
    
        // This uses a regular expression to split the input string at the boundary 
        // between a non-digit (\\D) and a digit (\\d). The (?<=...) and (?=...) are 
        // lookbehind and lookahead assertions, respectively. They make the split happen 
        // before or after the match, without consuming the match.
        String[] tokens = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        Queue<String> outputQueue = new LinkedList<>();
        Stack<String> operatorStack = new Stack<>();
        
    }


    /**
     * Helper method to check if a token is number
     * @param token
     * @return boolean
     */
    public static boolean isNumber(String token) {
        for(char c: token.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method to check if a token is an operator
     * @param token
     * @return boolean
     */
    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-")
            || token.equals("/") || token.equals("*");
    }

    /**
     * Helper method to determine precedence of operators
     * @param token
     * @return precedence
     */
    public static int precedence(String token) {
        int precedence = 0;

        switch(token) {
            case "+":
            case "-":
                precedence = 2;
                break;
            case "*":
            case "/":
                precedence = 3;
                break;
            case "^":
                precedence = 4;
            default:
                precedence = -1;
                break;
        }
        return precedence;
    }

    public static double evaluateRPN(Queue<String> tokens) {
        Stack<Double> stack = new Stack<>();

        for(String token : tokens) {
            if (isNumber(token)) {
                double num = Double.parseDouble(token);
                stack.push(num);
            } else if (isOperator(token)) {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double result;

                switch(token) {
                    case "+":
                        result = num1+num2;
                        break;
                    case "-":
                        result = num1-num2;
                        break;
                    case "/":
                        if(num1 != 0) {
                            result = num1/num2;
                        } else {
                            throw new ArithmeticException("Cannot divide by zero");
                        }
                        break;
                    case "*":
                        result = num1*num2;
                        break;
                    case "^":
                        result = Math.pow(num2, num1);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
                stack.push(result);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN Expression");
        }
        return stack.pop();
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
