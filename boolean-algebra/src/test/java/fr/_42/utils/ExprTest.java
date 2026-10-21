package fr._42.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

public class ExprTest {

    @Test
    public void equalObjects() {
        String rpnFormula = "AB^";
        Expr obj1 = RpnParser.parseRpn(rpnFormula);
        Expr obj2 = RpnParser.parseRpn(rpnFormula);
        assertEquals(obj1, obj2);
    }

    @Test
    public void equalObjectsFromAssignedSameObjectPointer() {
        String rpnFormula = "AB^";
        Expr obj1 = RpnParser.parseRpn(rpnFormula);
        Expr obj2 = obj1;
        assertEquals(obj1, obj2);
    }

    @Test
    public void notEqualObjects() {
        String rpnFormula = "AB^";
        Expr obj1 = RpnParser.parseRpn(rpnFormula);
        Expr obj2 = obj1.left;
        assertNotEquals(obj1, obj2);
    }
    
}
