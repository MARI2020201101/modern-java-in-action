package ch05;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        List<int[]> fiboList = Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(20)
                .collect(Collectors.toList());
        for (int[] ints : fiboList) {
            System.out.print(Arrays.toString(ints) + " ");
        }
        System.out.println();
        System.out.println("=================================================");

        List<Integer> fiboList2 = Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(20)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(fiboList2);
        System.out.println("=================================================");

        List<Integer> fiboList3 = Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(20)
                .map(i -> i[0])
                .collect(Collectors.toList());
        System.out.println(fiboList3);

    }
}
