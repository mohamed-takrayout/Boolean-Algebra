package fr._42.conjunctive_normal_form.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ConjunctiveNormalFormTest {

    @Test
    public void conjunctiveNormalFormKeepsSimpleCnf() {
        // Arrange
        String formula = "AB|C&";

        // Act
        String result = ConjunctiveNormalForm.conjunctive_normal_form(formula);

        // Assert
        assertEquals("AB|C&", result);
    }

    @Test
    public void conjunctiveNormalFormTransformsNegatedAnd() {
        // Arrange
        String formula = "AB&!";

        // Act
        String result = ConjunctiveNormalForm.conjunctive_normal_form(formula);

        // Assert
        assertEquals("A!B!|", result);
    }

    @Test
    public void conjunctiveNormalFormRejectsInvalidFormula() {
        // Arrange
        String invalidFormula = "A!B";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> ConjunctiveNormalForm.conjunctive_normal_form(invalidFormula));
    }
}
