package ch03;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class IntegralWithFunction {

    public static void main(String[] args) {
        System.out.println(integrate((x) -> x + 10, 3, 7));
    }
    public static int integrate(UnaryOperator<Integer> o, Integer x1, Integer x2){
        return (x2-x1)*(o.apply(x2)+o.apply(x1))/2;
    }
}
