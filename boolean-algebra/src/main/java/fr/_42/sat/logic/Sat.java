package fr._42.sat.logic;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import fr._42.utils.Expr;
import fr._42.utils.RpnParser;
import fr._42.utils.TruthTable;

public class Sat {

    public static boolean sat(String formul) {
        Expr formulTree = RpnParser.parseRpn(formul);
        Set<Character> variablesSet = new LinkedHashSet<>();
        for (char c : formul.toCharArray()) {
            if (TruthTable.isVariable(c)) {
                variablesSet.add(c);
            }
        }
        List<Character> variablesList = new ArrayList<>(variablesSet);
        char[][] truthTable = TruthTable.fillTruthTable(variablesList, formulTree);
        for (int i = 1; i < truthTable.length; i++) {
            if (truthTable[i][truthTable[i].length - 1] == '1') {
                return true;
            }
        }
        return false;
    }
}
