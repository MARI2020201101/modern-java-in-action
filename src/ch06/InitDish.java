package ch06;

import java.util.ArrayList;
import java.util.List;

public class InitDish {

    private List<Dish> dishes = new ArrayList<>();

    public InitDish(){
        dishes.add(new Dish("chicken breast",false,270,Dish.Type.MEAT));
        dishes.add(new Dish("beef liver",false,380,Dish.Type.MEAT));
        dishes.add(new Dish("tuna",false,400,Dish.Type.FISH));
        dishes.add(new Dish("salmon",false,450,Dish.Type.FISH));
        dishes.add(new Dish("mackerel",false,370,Dish.Type.FISH));
        dishes.add(new Dish("turkey",false,500,Dish.Type.MEAT));
        dishes.add(new Dish("chickpea",true,450,Dish.Type.OTHER));
        dishes.add(new Dish("rice",true,300,Dish.Type.OTHER));
        dishes.add(new Dish("tomato",true,150,Dish.Type.OTHER));
        dishes.add(new Dish("almond",true,600,Dish.Type.OTHER));
        dishes.add(new Dish("tahini",true,580,Dish.Type.OTHER));
        dishes.add(new Dish("tamarind",true,100,Dish.Type.OTHER));
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
