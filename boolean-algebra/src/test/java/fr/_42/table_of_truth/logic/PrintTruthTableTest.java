package fr._42.table_of_truth.logic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PrintTruthTableTest {

    @Test
    public void printTruthTablePrintsTheHeaderAndValues() {
        // Arrange
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));

            // Act
            PrintTruthTable.printTruthTable("A");
        } finally {
            System.setOut(originalOut);
        }

        // Assert
        String printed = output.toString();
        assertTrue(printed.contains("A"));
        assertTrue(printed.contains("="));
        assertTrue(printed.contains("0"));
        assertTrue(printed.contains("1"));
    }

    @Test
    public void printTruthTableRejectsInvalidChar() {
        // Arrange
        String invalidFormula = "A@";

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> PrintTruthTable.printTruthTable(invalidFormula));
    }
}
