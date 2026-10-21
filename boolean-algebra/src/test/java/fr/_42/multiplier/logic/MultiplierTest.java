package fr._42.multiplier.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MultiplierTest {

    @Test
    public void multiplierWithPositiveValues() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int result = Multiplier.multiplier(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void multiplierWithMixedSigns() {
        // Arrange
        int firstA = -3;
        int firstB = 5;
        int secondA = 3;
        int secondB = -5;

        // Act
        int firstResult = Multiplier.multiplier(firstA, firstB);
        int secondResult = Multiplier.multiplier(secondA, secondB);

        // Assert
        assertEquals(-15, firstResult);
        assertEquals(-15, secondResult);
    }

    @Test
    public void multiplierWithNegativeValues() {
        // Arrange
        int a = -3;
        int b = -5;

        // Act
        int result = Multiplier.multiplier(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void multiplierWithZero() {
        // Arrange
        int a = 0;
        int b = 9;

        // Act
        int result = Multiplier.multiplier(a, b);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void multiplierHandlesOneAndMinusOne() {
        // Arrange
        int one = 1;
        int minusOne = -1;

        // Act
        int oneResult = Multiplier.multiplier(one, 12345);
        int minusOneResult = Multiplier.multiplier(minusOne, 12345);

        // Assert
        assertEquals(12345, oneResult);
        assertEquals(-12345, minusOneResult);
    }

    @Test
    public void multiplierHandlesLargeProductBoundary() {
        // Arrange
        int a = Integer.MAX_VALUE;
        int b = 2;

        // Act
        int result = Multiplier.multiplier(a, b);

        // Assert
        assertEquals(-2, result);
    }
}
