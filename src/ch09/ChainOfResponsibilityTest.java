package ch09;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        String string = "modern java in action";

        ProcessUpperCase p1 = new ProcessUpperCase();
        ProcessDecorateString p2 = new ProcessDecorateString();
        p2.setNext(p1);

        String processedString = p2.handle(string);
        System.out.println(processedString);

        System.out.println("----------------");
        UnaryOperator<String> u1 = s ->"######\n" + s + "\n######";
        UnaryOperator<String> u2 = String::toUpperCase;
        Function<String,String> f = u1.andThen(u2);
        
        String processedByLambda = f.apply(string);
        System.out.println(processedByLambda);
    }
}
