package fr._42.negation_normal_form.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class NegationNormalFormTest {

    @Test
    public void negationNormalFormForAndExpression() {
        // Arrange
        String formula = "AB&!";

        // Act
        String result = NegationNormalForm.negation_normal_form(formula);

        // Assert
        assertEquals("A!B!|", result);
    }

    @Test
    public void negationNormalFormForOrExpression() {
        // Arrange
        String formula = "AB|!";

        // Act
        String result = NegationNormalForm.negation_normal_form(formula);

        // Assert
        assertEquals("A!B!&", result);
    }

    @Test
    public void negationNormalFormForImplication() {
        // Arrange
        String formula = "AB>";

        // Act
        String result = NegationNormalForm.negation_normal_form(formula);

        // Assert
        assertEquals("A!B|", result);
    }

    @Test
    public void negationNormalFormForDoubleNegation() {
        // Arrange
        String formula = "A!!";

        // Act
        String result = NegationNormalForm.negation_normal_form(formula);

        // Assert
        assertEquals("A", result);
    }

    @Test
    public void negationNormalFormForEquivalence() {
        // Arrange
        String formula = "AB=";

        // Act
        String result = NegationNormalForm.negation_normal_form(formula);

        // Assert
        assertEquals("AB&A!B!&|", result);
    }

    @Test
    public void negationNormalFormRejectsUnsupportedOperator() {
        // Arrange
        String invalidFormula = "AB@";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> NegationNormalForm.negation_normal_form(invalidFormula));
    }
}
