import org.example.Calculator;
import org.example.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001);
    }

    @Test
    public void testSubtract() {
        assertEquals(2.0, calculator.subtract(5.0, 3.0), 0.001);
    }

    @Test
    public void testMultiply() {
        assertEquals(6.0, calculator.multiply(2.0, 3.0), 0.001);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001);
    }

    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class,
                () -> calculator.divide(5.0, 0.0));
        assertEquals("Помилка: Ділення на нуль неможливе.", exception.getMessage());
    }

    @Test
    public void testSqrt() throws InvalidInputException {
        assertEquals(3.0, calculator.sqrt(9.0), 0.001);
    }

    @Test
    public void testSqrtNegative() {
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> calculator.sqrt(-9.0));
        assertEquals("Помилка: Негативне число не може мати квадратний корінь.", exception.getMessage());
    }
}
