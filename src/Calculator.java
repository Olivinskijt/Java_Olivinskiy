public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Ділення на нуль неможливе!");
        }
        return a / b;
    }

    public double sqrt(double number) throws InvalidInputException {
        if (number < 0) {
            throw new InvalidInputException("Число для квадратного кореня не може бути менше нуля!");
        }
        return Math.sqrt(number);
    }
}