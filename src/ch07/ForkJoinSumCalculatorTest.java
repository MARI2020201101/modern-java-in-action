package ch07;

import java.util.stream.LongStream;

public class ForkJoinSumCalculatorTest {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();
        ForkJoinSumCalculator calculator = new ForkJoinSumCalculator(numbers);
        Long result = calculator.compute();
        System.out.println(result);
    }
}
