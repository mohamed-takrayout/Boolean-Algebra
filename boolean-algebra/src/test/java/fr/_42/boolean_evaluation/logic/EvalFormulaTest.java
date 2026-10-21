package fr._42.boolean_evaluation.logic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EvalFormulaTest {

    @Test
    public void evalFormulaWithAndOperation() {
        // Arrange
        String formula = "10&";

        // Act
        boolean result = EvalFormula.evalFormula(formula);

        // Assert
        assertFalse(result);
    }

    @Test
    public void evalFormulaWithOrOperation() {
        // Arrange
        String formula = "10|";

        // Act
        boolean result = EvalFormula.evalFormula(formula);

        // Assert
        assertTrue(result);
    }

    @Test
    public void evalFormulaWithImplicationOperation() {
        // Arrange
        String trueFormula = "11>";
        String falseFormula = "10>";

        // Act
        boolean trueResult = EvalFormula.evalFormula(trueFormula);
        boolean falseResult = EvalFormula.evalFormula(falseFormula);

        // Assert
        assertTrue(trueResult);
        assertFalse(falseResult);
    }

    @Test
    public void evalFormulaWithEquivalenceOperation() {
        // Arrange
        String falseFormula = "10=";
        String trueFormula = "11=";

        // Act
        boolean falseResult = EvalFormula.evalFormula(falseFormula);
        boolean trueResult = EvalFormula.evalFormula(trueFormula);

        // Assert
        assertFalse(falseResult);
        assertTrue(trueResult);
    }

    @Test
    public void evalFormulaWithNegationAndCombinedOperators() {
        // Arrange
        String formula = "10|1&";

        // Act
        boolean result = EvalFormula.evalFormula(formula);

        // Assert
        assertTrue(result);
    }

    @Test
    public void evalFormulaWithInvalidExpression() {
        // Arrange
        String invalidFormula = "11>>";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> EvalFormula.evalFormula(invalidFormula));
    }

    @Test
    public void evalFormulaRejectsNonBinarySymbol() {
        // Arrange
        String invalidFormula = "1a&";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> EvalFormula.evalFormula(invalidFormula));
    }
}
