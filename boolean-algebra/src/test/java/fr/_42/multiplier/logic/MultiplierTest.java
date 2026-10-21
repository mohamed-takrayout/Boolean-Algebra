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
        assertEquals(a * b, result);
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
        assertEquals(firstA * firstB, firstResult);
        assertEquals(secondA * secondB, secondResult);
    }

    @Test
    public void multiplierWithNegativeValues() {
        // Arrange
        int a = -3;
        int b = -5;

        // Act
        int result = Multiplier.multiplier(a, b);

        // Assert
        assertEquals(a * b, result);
    }

    @Test
    public void multiplierWithZero() {
        // Arrange
        int a = 0;
        int b = 9;

        // Act
        int result = Multiplier.multiplier(a, b);

        // Assert
        assertEquals(a * b, result);
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
        assertEquals(one * 12345, oneResult);
        assertEquals(minusOne * 12345, minusOneResult);
    }

    @Test
    public void multiplierHandlesLargeProductBoundary() {
        // Arrange
        int a = Integer.MAX_VALUE;
        int b = 2;

        // Act
        int result = Multiplier.multiplier(a, b);

        // Assert
        assertEquals(a * b, result);
    }
}
