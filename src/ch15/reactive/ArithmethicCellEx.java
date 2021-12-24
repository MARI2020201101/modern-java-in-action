package ch15.reactive;

public class ArithmethicCellEx {
    public static void main(String[] args) {
        ArithmeticCell c3 = new ArithmeticCell("C3");
        SimpleCell c1 = new SimpleCell("C1");
        SimpleCell c2 = new SimpleCell("C2");

        c1.subscribe(c3);
        c2.subscribe(c3);

        c3.onNext(11);
        c1.onNext(10);
        c2.onNext(20);
        c1.onNext(15);

        System.out.println(c3.left);
        System.out.println(c3.right);//????
    }
}
