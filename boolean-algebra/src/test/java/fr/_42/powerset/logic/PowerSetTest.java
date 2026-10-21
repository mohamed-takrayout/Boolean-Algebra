package fr._42.powerset.logic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PowerSetTest {

    @Test
    public void powersetGeneratesAllSubsets() {
        // Arrange
        List<Integer> input = List.of(1, 2);
        List<List<Integer>> expected = List.of(List.of(), List.of(1), List.of(2), List.of(1, 2));

        // Act
        List<List<Integer>> result = PowerSet.powerset(input);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void powersetOfEmptySet() {
        // Arrange
        List<Integer> input = List.of();
        List<List<Integer>> expected = List.of(List.of());

        // Act
        List<List<Integer>> result = PowerSet.powerset(input);

        // Assert
        assertEquals(expected, result);
    }
}
