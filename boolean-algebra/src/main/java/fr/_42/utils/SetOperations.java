package fr._42.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class SetOperations {

    public static <T> List<T> union(List<T> set1, List<T> set2) {
        if (set1 == null || set1.isEmpty()) {
            return set2 == null ? new ArrayList<>() : new ArrayList<>(set2);
        }
        if (set2 == null || set2.isEmpty()) {
            return new ArrayList<>(set1);
        }

        LinkedHashSet<T> resultSet = new LinkedHashSet<>(set1);
        resultSet.addAll(set2);
        return new ArrayList<>(resultSet);
    }

    public static <T> List<T> intersection(List<T> set1, List<T> set2) {
        if (set1 == null || set1.isEmpty() || set2 == null || set2.isEmpty()) {
            return new ArrayList<>();
        }

        Set<T> set2Lookup = new LinkedHashSet<>(set2);
        List<T> result = new ArrayList<>();
        for (T value : set1) {
            if (set2Lookup.contains(value) && !result.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    public static <T> List<T> complement(List<T> set, List<T> universalSet) {
        if (universalSet == null || universalSet.isEmpty()) {
            return new ArrayList<>();
        }

        Set<T> excluded = new LinkedHashSet<>(set == null ? List.of() : set);
        List<T> result = new ArrayList<>();
        for (T value : universalSet) {
            if (!excluded.contains(value)) {
                result.add(value);
            }
        }
        return result;
    }

    public static <T> List<T> getUniversalSet(List<List<T>> sets){
        return sets.stream().flatMap(List::stream).distinct().toList();
    }

}
