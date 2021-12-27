package ch06;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class GroupingEx extends InitDish {
    public static void main(String[] args) {
        GroupingEx g = new GroupingEx();
        List<Dish> dishes = g.getDishes();
        Map<Dish.Type, List<Dish>> groupByType = dishes.stream().collect(
                groupingBy(Dish::getType)
        );
        System.out.println(groupByType);

        System.out.println("----------------------------------------");
        Map<Dish.Type, List<Dish>> groupByTypeAndCal = dishes.stream()
                .collect(groupingBy(Dish::getType,
                        filtering(d -> d.getCalories() > 400, toList())));
        System.out.println(groupByTypeAndCal);

        System.out.println("----------------------------------------");
        Map<Dish.Type, List<String>> groupByTypeWithName = dishes.stream()
                .collect(groupingBy(Dish::getType,
                        mapping(Dish::getName, toList())));
        System.out.println(groupByTypeWithName);

        System.out.println("----------------------------------------");
        String joinedDishName = dishes.stream()
                .map(Dish::getName)
                .collect(joining(" , "));
        System.out.println(joinedDishName);
    }
}
