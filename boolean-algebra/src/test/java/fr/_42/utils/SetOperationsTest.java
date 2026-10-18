package fr._42.utils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SetOperationsTest {

    @Test
    public void unionWithDuplicateValuesTest() {
        List<Integer> set1 = List.of(1, 2, 3, 4);
        List<Integer> set2 = List.of(1, 2, 5, 6);

        List<Integer> expectedResult = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = SetOperations.union(set1, set2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void unionWithNonDuplicateValuesTest() {
        List<Integer> set1 = List.of(1, 2, 3, 4);
        List<Integer> set2 = List.of(5, 6, 7, 8);

        List<Integer> expectedResult = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> result = SetOperations.union(set1, set2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void unionWithViodSetTest() {
        List<Integer> set1 = List.of(1, 2, 3, 4);
        List<Integer> set2 = List.of();

        List<Integer> expectedResult = List.of(1, 2, 3, 4);
        List<Integer> result = SetOperations.union(set1, set2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void intersectionWithDuplicateValuesTest() {
        List<Integer> set1 = List.of(1, 2, 3, 4);
        List<Integer> set2 = List.of(1, 2, 5, 6);

        List<Integer> expectedResult = List.of(1, 2);
        List<Integer> result = SetOperations.intersection(set1, set2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void intersectionWithNonDuplicateValuesTest() {
        List<Integer> set1 = List.of(1, 2, 3, 4);
        List<Integer> set2 = List.of(5, 6, 7, 8);

        List<Integer> expectedResult = List.of();
        List<Integer> result = SetOperations.intersection(set1, set2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void intersectionWithDuplicateSetTest() {
        List<Integer> set1 = List.of(1, 2, 3, 4);
        List<Integer> set2 = List.of(1, 2, 3, 4);

        List<Integer> expectedResult = List.of(1, 2, 3, 4);
        List<Integer> result = SetOperations.intersection(set1, set2);
        assertEquals(expectedResult, result);
    }

    @Test
    public void complement_in_universe_with_only_one_sets() {
        List<Integer> set1 = List.of(1, 2, 3, 4);
        List<Integer> universalSet = set1;

        List<Integer> expectedResult = List.of();
        List<Integer> result = SetOperations.complement(set1, universalSet);
        assertEquals(expectedResult, result);
    }

    @Test
    public void complement_in_universe_with_two_non_identical_sets() {
        List<Integer> set1 = List.of(1, 2, 3, 4);
        List<Integer> set2 = List.of(5, 6, 7, 8);
        List<Integer> universalSet = SetOperations.union(set1, set2);

        List<Integer> expectedResult = set2;
        List<Integer> result = SetOperations.complement(set1, universalSet);
        assertEquals(expectedResult, result);
    }

    @Test
    public void complement_in_universe_with_some_identical_values() {
        List<Integer> set1 = List.of(1, 2, 3, 4);
        List<Integer> set2 = List.of(3, 4, 7, 8);
        List<Integer> universalSet = SetOperations.union(set1, set2);

        List<Integer> expectedResult = List.of(7, 8);
        List<Integer> result = SetOperations.complement(set1, universalSet);
        assertEquals(expectedResult, result);
    }

    @Test
    public void complement_of_void_set_in_non_void_univers() {
        List<Integer> set1 = List.of();
        List<Integer> set2 = List.of(3, 4, 5, 6);
        List<Integer> universalSet = SetOperations.union(set1, set2);

        List<Integer> expectedResult = set2;
        List<Integer> result = SetOperations.complement(set1, universalSet);
        assertEquals(expectedResult, result);
    }
}
