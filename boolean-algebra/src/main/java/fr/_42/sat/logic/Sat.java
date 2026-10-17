package fr._42.sat.logic;

import fr._42.utils.Expr;
import fr._42.utils.RpnParser;
import fr._42.utils.TruthTable;
import java.util.ArrayList;
import java.util.List;

public class Sat {

    public static boolean sat(String formul) {
        Expr formulTree = RpnParser.parseRpn(formul);
        List<Character> variablesList = new ArrayList<>();
        for (char c : formul.toCharArray()) {
            if (TruthTable.isVariable(c) && !variablesList.contains(c)) {
                variablesList.add(c);
            }
        }
        char[][] truthTable = TruthTable.fillTruthTable(variablesList, formulTree);
        for (char[] truthTable1 : truthTable) {
            if (truthTable1[truthTable1.length - 1] == '1') {
                return true;
            }
        }
        return false;
    }
}
