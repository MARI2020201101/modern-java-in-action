package ch03;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceEx {
    public static void main(String[] args) {
        Supplier<AppleV2> s = AppleV2::new;
        AppleV2 apple = s.get();
        System.out.println(apple);

        Function<String, AppleV2> f = AppleV2::new;
        AppleV2 apple2 = f.apply("delicious!");
        System.out.println(apple2);

        BiFunction<String,Integer, AppleV2> bf = AppleV2::new;
        bf.apply("best apple",100);

        Map<String, Function<String, Fruit>> map = mapFruit();
        Function<String, Fruit> af = map.get("apple");
        Fruit huzi = af.apply("huzi");
        System.out.println(huzi);
        Function<String, Fruit> gf = map.get("grape");
        Fruit sweet = gf.apply("sweet");
        System.out.println(sweet);


    }

    public static  Map<String, Function<String,Fruit>> mapFruit(){
        Map<String, Function<String,Fruit>> map = new HashMap<>();
        map.put("apple", Apple::new);
        map.put("orange", Fruit::new);
        map.put("grape",Fruit::new);
        return map;
    }
}
