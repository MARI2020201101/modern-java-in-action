package ch03;

public class Apple extends Fruit {

    private Color color;
    private int weight;

    public Apple(String name) {
        super(name);

    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public Apple(String name, Color color, int weight) {
        super(name);
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + getName() +
                "', color=" + color +
                ", weight=" + weight +
                '}';
    }

//    @Override
//    public String toString() {
//
//        return "Apple{" +super.toString() +
//
//                "', color=" + color +
//                ", weight=" + weight +
//                '}';
//    }

    public static enum Color{
        RED,GREEN;
    }
}
