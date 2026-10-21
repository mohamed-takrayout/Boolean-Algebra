package fr._42.sat.logic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SatTest {

    @Test
    public void satReturnsTrueWhenFormulaIsSatisfiable() {
        // Arrange
        String satisfiableFormula1 = "AB|";
        String satisfiableFormula2 = "A";

        // Act
        boolean firstResult = Sat.sat(satisfiableFormula1);
        boolean secondResult = Sat.sat(satisfiableFormula2);

        // Assert
        assertTrue(firstResult);
        assertTrue(secondResult);
    }

    @Test
    public void satReturnsFalseWhenFormulaIsUnsatisfiable() {
        // Arrange
        String unsatisfiableFormula1 = "AA!&";
        String unsatisfiableFormula2 = "AA^";

        // Act
        boolean firstResult = Sat.sat(unsatisfiableFormula1);
        boolean secondResult = Sat.sat(unsatisfiableFormula2);

        // Assert
        assertFalse(firstResult);
        assertFalse(secondResult);
    }

    @Test
    public void satHandlesNegationAndCombinationCases() {
        // Arrange
        String formula1 = "A!";
        String formula2 = "AB&";
        String formula3 = "AB&AB&!&";

        // Act
        boolean result1 = Sat.sat(formula1);
        boolean result2 = Sat.sat(formula2);
        boolean result3 = Sat.sat(formula3);

        // Assert
        assertTrue(result1);
        assertTrue(result2);
        assertFalse(result3);
    }

    @Test
    public void satHandlesSingleVariableAndFalseCases() {
        // Arrange
        String formula1 = "A!";
        String formula2 = "A!A&";

        // Act
        boolean result1 = Sat.sat(formula1);
        boolean result2 = Sat.sat(formula2);

        // Assert
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void satRejectsInvalidFormula() {
        // Arrange
        String invalidFormula = "A@";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> Sat.sat(invalidFormula));
    }
}
