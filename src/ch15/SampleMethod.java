package ch15;

import java.util.function.IntFunction;

public class SampleMethod {

    public static int f(int x, IntFunction<Integer> function){
        return function.apply(x);
    }
}
