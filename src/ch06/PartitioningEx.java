package ch06;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

public class PartitioningEx extends InitDish{
    public static void main(String[] args) {
        PartitioningEx p = new PartitioningEx();
        List<Dish> dishes = p.getDishes();
        Map<Boolean, List<Dish>> isVegMenu = dishes.stream()
                .collect(partitioningBy(Dish::isVegetarian)); //true - false 인경우에 파티셔닝할수있다.
        System.out.println(isVegMenu);

        System.out.println("---------------------------------");
        List<Dish> isVegMenuY = isVegMenu.get(true);
        System.out.println(isVegMenuY);

    }
}
