import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
        assertEquals("Ділення на нуль неможливе!", exception.getMessage());
    }

    @Test
    void testInvalidInputExceptionForSqrt() {
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> calculator.sqrt(-4)
        );
        assertEquals("Число для квадратного кореня не може бути менше нуля!", exception.getMessage());
    }

    @Test
    @SneakyThrows
    void testValidOperations() {
        assertEquals(5.0, calculator.add(2, 3));
        assertEquals(2.0, calculator.subtract(5, 3));
        assertEquals(6.0, calculator.multiply(2, 3));
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(4.0, calculator.sqrt(16));
    }
}