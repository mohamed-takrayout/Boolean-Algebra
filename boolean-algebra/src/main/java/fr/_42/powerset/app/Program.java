package fr._42.powerset.app;

import fr._42.powerset.logic.PowerSet;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        List<Integer> list2 = List.of(1, 2);
        System.out.println("Power set of set:" + list);
        for (List lst : PowerSet.powerset(list)) {
            System.out.println(lst);
        }
        System.out.println("Power set of set:" + list2);
        for (List lst : PowerSet.powerset(list2)) {
            System.out.println(lst);
        }
    }
}
