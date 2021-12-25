package ch03;

import ch02.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx {

    public static void main(String[] args) {
        Apple a1 = new Apple("huji", Apple.Color.RED,300);
        Apple a2 = new Apple("busa", Apple.Color.RED,250);
        Apple a3 = new Apple("yummy", Apple.Color.RED,100);
        Apple a4 = new Apple("wasakwassak", Apple.Color.GREEN,200);
        Apple a5 = new Apple("delicious", Apple.Color.GREEN,150);

        List<Apple> appleList = new ArrayList<>();
        appleList.add(a1);
        appleList.add(a2);
        appleList.add(a3);
        appleList.add(a4);
        appleList.add(a5);

        appleList.sort(Comparator.comparingInt((Apple::getWeight)));
        System.out.println(appleList);

    }
}
