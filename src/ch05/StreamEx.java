package ch05;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx extends InitDish{
    public static void main(String[] args) {
        StreamEx s = new StreamEx();
        List<Dish> dishes = s.getDishes();

        List<Dish> lowerThan400CalDishes2 = dishes.stream()
                .filter((d) -> d.getCalories() < 400)
                .collect(Collectors.toList());
        System.out.println(lowerThan400CalDishes2);

        System.out.println();

        List<Dish> lowerThan400CalDishes = dishes.stream()
                .takeWhile((d) -> d.getCalories() < 400)
                .collect(Collectors.toList());
        System.out.println(lowerThan400CalDishes);
        //filter와 달리 while문이기 때문에 만나면 바로 종료됨

        System.out.println();

        List<String> dishesNameList = dishes.stream()
                .flatMap((d1) ->
                        lowerThan400CalDishes.stream()
                                .filter((d2) -> d1 == d2)
                                .map((d2) -> d2.getName())
                ).collect(Collectors.toList());
        System.out.println(dishesNameList);

        List<Stream<String>> collect = dishes.stream()
                .map((d1) -> //일반 map을 쓰면 . 지금 stream 안에 stream을 한번 더 만들었기 때문에
                        // 리턴타입이 list<Stream~~타입이 된다.
                        lowerThan400CalDishes.stream()
                                .filter((d2) -> d1 == d2)
                                .map((d2) -> d2.getName())
                ).collect(Collectors.toList());

    }
}
