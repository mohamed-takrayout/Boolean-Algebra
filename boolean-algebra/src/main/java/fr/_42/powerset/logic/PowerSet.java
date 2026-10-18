package fr._42.powerset.logic;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static List<List<Integer>> powerset(List<Integer> set) {
        List<List<Integer>> result = new ArrayList<>();
        int n = set.size();
        int powersetSize = 1 << n;
        for (int i = 0; i < powersetSize; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(set.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }
}
