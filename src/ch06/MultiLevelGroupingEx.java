package ch06;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class MultiLevelGroupingEx extends InitDish{
    public static void main(String[] args) {
        MultiLevelGroupingEx m = new MultiLevelGroupingEx();
        List<Dish> dishes = m.getDishes();
        Map<Dish.Type, Map<String, List<Dish>>> multiGroupingDishes = dishes.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy(d ->
                        {
                            if (d.getCalories() > 500) return "HighCal";
                            else if (d.getCalories() > 250) return "MidCal";
                            else return "LowCal";
                        })));
        //1. group하는 기준 2. group할 데이터 3.어떤 타입으로 group할것인지
        System.out.println(multiGroupingDishes);

        System.out.println("----------------------------------------------------------");
        Map<Dish.Type, Optional<Dish>> maxCalDishes = dishes.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(maxCalDishes);

        System.out.println("----------------------------------------------------------");
        Map<Dish.Type, HashSet<String>> groupByTypeAndMapByVeg = dishes.stream()
                .collect(groupingBy(Dish::getType, mapping(d -> {
                    if (d.isVegetarian()) return "VEG_MENU";
                    else return "BASIC_MENU";
                }, toCollection(HashSet::new)
        )));
        System.out.println(groupByTypeAndMapByVeg);
    }
}
