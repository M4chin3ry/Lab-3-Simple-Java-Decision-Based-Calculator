import java.util.Scanner;
public class DecisionBasedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueChoice = "";  
        System.out.println("Welcome to the Java Calculator!");
        do {
            System.out.print("Enter an operation (+, -, *, /, or exit): ");
            String operation = scanner.next();
            if (operation.equalsIgnoreCase("exit")) {
                break;
            }
            if (!(operation.equals("+") || operation.equals("-") || 
                  operation.equals("*") || operation.equals("/"))) {
                System.out.println("Error: Invalid operation. Please enter +, -, *, /, or exit.");
                continue;
            }
            // Get operands
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();
            // Range check for operands
            if ((num1 < -1000 || num1 > 1000) || (num2 < -1000 || num2 > 1000)) {
                System.out.println("Error: Numbers must be between -1000 and 1000.");
                continue;
            }
            // Perform the calculation
            double result = 0;
            boolean validOperation = true;
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    validOperation = false;
                    break;
            }
            // Display result
            if (validOperation) {
                System.out.println("The result of " + num1 + " " + operation + " " + num2 + " = " + result);
            }
            // Ask to continue
            System.out.print("Would you like to perform another operation (yes/no)? ");
            continueChoice = scanner.next();
        } while (continueChoice.equalsIgnoreCase("yes"));
        System.out.println("Thank you for using the Java Calculator! Goodbye!");
        scanner.close();
    }
}
