package ch05;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapEx {
    public static void main(String[] args) {
        List<Integer> numList1 = Arrays.asList(1, 2, 3);
        List<Integer> numList2 = Arrays.asList(4, 5);

        Set<int[]> allOfSet = numList1.stream()
                .flatMap((n1) ->
                        numList2.stream()
                                .map((n2) -> new int[]{n1, n2}))
                .collect(Collectors.toSet());

        for (int[] ints : allOfSet) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println("------------------------------------------------");
        List<List<Integer>> allSetOfNumList = numList1.stream()
                .flatMap((n1) ->
                        numList2.stream()
                                .map((n2) -> List.of(n1, n2))
                ).collect(Collectors.toList());
        System.out.println(allSetOfNumList);

        System.out.println("------------------------------------------------");
        List<List<Integer>> dividedBy3Nums = numList1.stream()
                .flatMap((n1) ->
                        numList2.stream()
                                .filter(n2 -> (n1 + n2) % 3 == 0)
                                .map((n2) -> List.of(n1, n2)))
                .collect(Collectors.toList());
        System.out.println(dividedBy3Nums);

    }
}
