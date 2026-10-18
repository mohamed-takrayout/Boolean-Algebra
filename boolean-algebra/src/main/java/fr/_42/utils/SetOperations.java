package fr._42.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SetOperations {

    public static <T> List<T> union(List<T> set1, List<T> set2) {
        if (set1 == null || set1.isEmpty()) {
            return set2;
        }
        if (set2 == null || set2.isEmpty()) {
            return set1;
        }
        List<T> resultSet = new ArrayList<>(set1);
        resultSet.addAll(set2);
        return Stream.concat(set1.stream(), set2.stream()).distinct().collect(Collectors.toList());
    }

    public static <T> List<T> intersection(List<T> set1, List<T> set2) {
        if (set1 == null || set1.isEmpty() || set2 == null || set2.isEmpty()) {
            return new ArrayList<>();
        }
        return set1.stream().filter((T a) -> {
            return set2.contains(a);
        }).collect(Collectors.toList());
    }

    public static <T> List<T> complement(List<T> set, List<T> universalSet) {
        return universalSet.stream().filter((T a) -> {
            return !set.contains(a);
        }).collect(Collectors.toList());
    }

    public static <T> List<T> getUniversalSet(List<List<T>> sets){
        return sets.stream().flatMap(List::stream).distinct().toList();
    } 

}
