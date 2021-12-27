package ch09;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        String string = "modern java in action";

        ProcessUpperCase p1 = new ProcessUpperCase();
        ProcessDecorateString p2 = new ProcessDecorateString();
        p2.setNext(p1);

        String processedString = p2.handle(string);
        System.out.println(processedString);
    }
}
