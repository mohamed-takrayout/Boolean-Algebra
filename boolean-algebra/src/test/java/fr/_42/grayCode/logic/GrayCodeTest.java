package fr._42.grayCode.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GrayCodeTest {

    @Test
    public void grayCodeForZeroAndOne() {
        // Arrange
        int zero = 0;
        int one = 1;

        // Act
        int zeroResult = GrayCode.gray(zero);
        int oneResult = GrayCode.gray(one);

        // Assert
        assertEquals(0, zeroResult);
        assertEquals(1, oneResult);
    }

    @Test
    public void grayCodeForSeveralValues() {
        // Arrange
        int first = 2;
        int second = 3;
        int third = 4;

        // Act
        int firstResult = GrayCode.gray(first);
        int secondResult = GrayCode.gray(second);
        int thirdResult = GrayCode.gray(third);

        // Assert
        assertEquals(3, firstResult);
        assertEquals(2, secondResult);
        assertEquals(6, thirdResult);
    }

    @Test
    public void grayCodeForPowerOfTwoBoundary() {
        // Arrange
        int value = 8;

        // Act
        int result = GrayCode.gray(value);

        // Assert
        assertEquals(12, result);
    }

    @Test
    public void grayCodeForMaxValueBoundary() {
        // Arrange
        int value = Integer.MAX_VALUE;

        // Act
        int result = GrayCode.gray(value);

        // Assert
        assertEquals(1073741824, result);
    }
}
