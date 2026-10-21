package fr._42.adder.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AdderTest {

    @Test
    public void adderWithPositiveValues() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = Adder.adder(a, b);

        // Assert
        assertEquals(a + b, result);
    }

    @Test
    public void adderWithZero() {
        // Arrange
        int a = 0;
        int b = 0;

        // Act
        int result = Adder.adder(a, b);

        // Assert
        assertEquals(a + b, result);
    }

    @Test
    public void adderWithNegativeValue() {
        // Arrange
        int a = -3;
        int b = 2;

        // Act
        int result = Adder.adder(a, b);

        // Assert
        assertEquals(a + b, result);
    }

    @Test
    public void adderHandlesCarryPropagation() {
        // Arrange
        int a = Integer.MAX_VALUE;
        int b = 1;

        // Act
        int result = Adder.adder(a, b);

        // Assert
        assertEquals(a + b, result);
    }

    @Test
    public void adderWithMinValue(){
        // Arrange
        int a = Integer.MIN_VALUE;
        int b = -1;

        // Act
        int result = Adder.adder(a, b);

        // Assert
        assertEquals(a + b, result);
    }

    @Test
    public void adderHandlesLargeMixedValues() {
        // Arrange
        int a = 123456789;
        int b = -123456789;

        // Act
        int result = Adder.adder(a, b);

        // Assert
        assertEquals(a + b, result);
    }
}
