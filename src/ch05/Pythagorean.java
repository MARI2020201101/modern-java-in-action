package ch05;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pythagorean {

    public static void main(String[] args) {
        List<List<Integer>> pythagorasNums =
                IntStream.rangeClosed(1, 100).boxed() //map을 쓰기위하여. 박싱..으음~~~
                .flatMap((i) ->
                        IntStream.rangeClosed(i, 100)
                                .filter(j -> Math.sqrt(i * i + j * j) % 1 == 0)
                                .mapToObj(j -> List.of(i, j, (int) (Math.sqrt(i * i + j * j))))
                ).collect(Collectors.toList());


        //map은 int를 반환하기를 기대하지만. 나는 int list(혹은 배열) 을 원한다. 따라서 mapToObj를 쓴다.
        System.out.println(pythagorasNums);



    }
}
