package ch05;

import java.util.List;

public class ReduceEx extends InitDish{

    public static void main(String[] args) {
        ReduceEx r = new ReduceEx();
        List<Dish> dishes = r.getDishes();

        Dish maxCalDish = dishes.stream()
                .reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)
                .get();

        System.out.println(maxCalDish);

        System.out.println("-----------------------------------------------");
        Integer maxInt = List.of(1, 2, 3, 4, 5).stream()
                .reduce(Integer::max)
                .get();
        System.out.println(maxInt);
        System.out.println("-----------------------------------------------");

        long count = dishes.stream().count();
        System.out.println(count);
        System.out.println("-----------------------------------------------");

        Integer dishCount = dishes.stream()
                .map(d -> 1)
                .reduce((d1, d2) -> d1 + d2)
                .get();
        System.out.println(dishCount);//요소의 개수를 세는 두가지 방법


    }
}
