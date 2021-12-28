package ch18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        List<List<Integer>> subset = subset(List.of(3, 4, 5));
        System.out.println(subset);
    }


    public static List<List<Integer>> subset(List<Integer> list){

        if(list.isEmpty()){
            List<List<Integer>> result = new ArrayList<>();
            result.add(Collections.EMPTY_LIST);
            return result;
        }
        Integer first = list.get(0);
        List<Integer> sublist = list.subList(1, list.size());
        List<List<Integer>> subResult = subset(sublist);
        List<List<Integer>> subResult2 = insertAll(first, subResult);
        return concat(subResult, subResult2);

    }

    private static List<List<Integer>> concat(List<List<Integer>> subResult, List<List<Integer>> subResult2) {
        List<List<Integer>> result = new ArrayList<>(subResult);
        result.addAll(subResult2);
        return result;
    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subResult) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> subs : subResult) {
            List<Integer> copy = new ArrayList<>();
            copy.add(first);
            copy.addAll(subs);
            result.add(copy);
        }
        return result;
    }
}
