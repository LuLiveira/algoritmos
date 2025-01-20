package main.java.com.lucas.quicksort;

import java.util.ArrayList;
import java.util.List;

public record QuickSortExample() {


    public static void quickSort() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(33);
        integerList.add(77);
        integerList.add(11);
        integerList.add(12);
        integerList.add(16);
        integerList.add(99);
        integerList.add(143);
        System.out.println(quickSort(integerList));
    }

    static List<Integer> quickSort(List<Integer> integerList) {
        var menores = new ArrayList<Integer>();
        var maiores = new ArrayList<Integer>();
        if (integerList.isEmpty() || integerList.size() < 2) {
            return integerList;
        } else {
            var pivo = integerList.getFirst();
            for (int i = 1; i < integerList.size(); i++) {
                if (integerList.get(i) <= pivo) {
                    menores.add(integerList.get(i));
                }
                if (integerList.get(i) > pivo) {
                    maiores.add(integerList.get(i));
                }
            }

            var sorted = new ArrayList<>(quickSort(menores));
            sorted.add(pivo);
            sorted.addAll(quickSort(maiores));
            return sorted;
        }
    }
}