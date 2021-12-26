package ch05;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteStreamEx {
    public static void main(String[] args) {
        List<Integer> evenNums = Stream.iterate(2, i -> i + 2)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(evenNums);

        List<List<Integer>> fibonacci = Stream.iterate(1, i -> i + i)
                .limit(10)
                .flatMap(i ->
                        Stream.iterate(1, j -> i + j)
                                .limit(10)
                                .map(j -> List.of(i, j))
                ).collect(Collectors.toList());
        System.out.println(fibonacci);//뭐지.. 몰겠오... ㅜㅜ이게아닌디~~
    }
}
