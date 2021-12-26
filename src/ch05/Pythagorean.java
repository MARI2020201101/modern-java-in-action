package ch05;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pythagorean {

    public static void main(String[] args) {
        List<List<Integer>> pythagorasNums =
                IntStream.rangeClosed(1, 100).boxed() //map 하기위해서는 박싱이 필요한것인가?
                .flatMap((i) ->
                        IntStream.rangeClosed(i, 100)
                                .filter(j -> Math.sqrt(i * i + j * j) % 1 == 0)
                                .mapToObj(j -> List.of(i, j, (int) (Math.sqrt(i * i + j * j))))
                ).collect(Collectors.toList());

        System.out.println(pythagorasNums);

    }
}
