package ch06;

import java.util.List;
import java.util.Map;
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

        System.out.println(multiGroupingDishes);
    }
}
