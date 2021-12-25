package ch02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SimpleGenericFilter {


    public static void main(String[] args) {
        Fruit f1 = new Fruit("banana");
        Fruit f2 = new Fruit("orange");
        Fruit f3 = new Fruit("pineappple");
        Fruit f4 = new Fruit("watermelon");
        Fruit f5 = new Fruit("grape");

        List<Fruit> fruits = filter(List.of(f1, f2, f3, f4, f5), (f) -> f.getName().length() == 6);
        System.out.println(fruits);

        Apple a1 = new Apple("huji", Apple.Color.RED,300);
        Apple a2 = new Apple("busa", Apple.Color.RED,250);
        Apple a3 = new Apple("yummy", Apple.Color.RED,100);
        Apple a4 = new Apple("wasakwassak", Apple.Color.GREEN,200);
        Apple a5 = new Apple("delicious", Apple.Color.GREEN,150);

        List<Apple> redApples = filter(List.of(a1, a2, a3, a4, a5), (a) -> a.getColor() == Apple.Color.RED);
        System.out.println(redApples);

        List<Fruit> startWithB = filter(List.of(f1, f2, a1, a2, a3), (f) -> f.getName().charAt(0) == 'b');
        System.out.println(startWithB);
    }

    public static <T> List<T> filter(List<? extends T> src, Predicate<? super T> p){
        List<T> dst = new ArrayList<>();
        for (T item : src) {
            if (p.test(item)){
                dst.add(item);
            }
        }
        return dst;
    }
}
