package ch03;

import ch02.Fruit;

public class AppleV2 {

    private String name;
    private Color color;
    private int weight;


    public AppleV2() {
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public AppleV2(String name, Color color, int weight) {
        this.name=name;
        this.color = color;
        this.weight = weight;
    }

    public AppleV2(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public AppleV2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", weight=" + weight +
                '}';
    }

    public static enum Color{
        RED,GREEN;
    }
}
