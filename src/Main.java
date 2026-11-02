import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        try {
            System.out.print("Введіть перше число: ");
            double a = scanner.nextDouble();

            System.out.print("Введіть операцію (+, -, *, /, sqrt): ");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("sqrt")) {
                double result = calculator.sqrt(a);
                System.out.println("Результат: " + result);
            } else {
                System.out.print("Введіть друге число: ");
                double b = scanner.nextDouble();

                double result = switch (operation) {
                    case "+" -> calculator.add(a, b);
                    case "-" -> calculator.subtract(a, b);
                    case "*" -> calculator.multiply(a, b);
                    case "/" -> calculator.divide(a, b);
                    default -> throw new InvalidInputException("Непідтримувана операція: " + operation);
                };

                System.out.println("Результат: " + result);
            }

        } catch (InputMismatchException e) {
            System.out.println("Помилка вводу: Введено некоректні дані (очікувалося число)!");
        } catch (ArithmeticException | InvalidInputException e) {
            System.out.println("Помилка: " + e.getMessage());
        } finally {
            System.out.println("Завершення обробки запиту.");
            scanner.close();
        }
    }
}