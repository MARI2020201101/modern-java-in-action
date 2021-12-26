package ch05;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEx extends InitDish{
    public static void main(String[] args) {
        SortEx s = new SortEx();
        List<Dish> dishes = s.getDishes();

        List<Dish> sortedDishList = dishes.stream()
                .sorted(Comparator.comparingInt(Dish::getCalories)) //더 명확하게 쓸수있다.
                .collect(Collectors.toList());
        System.out.println(sortedDishList);

        List<Dish> sortedDishList2 = dishes.stream()
                .sorted((d1,d2)->d1.getCalories()- d2.getCalories())
                .collect(Collectors.toList());
    }
}
