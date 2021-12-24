package ch15.reactive;

public class SimpleCellEx {
    public static void main(String[] args) {
        SimpleCell c1 = new SimpleCell("C1");
        SimpleCell c2 = new SimpleCell("C2");
        SimpleCell c3 = new SimpleCell("C3");

        c1.subscribe(c2); //구독자 리스트에 추가되고

        c1.onNext(10);
        c1.onNext(11);
        c3.onNext(12); //구독하고 있지 않음.
    }
}
