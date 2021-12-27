package ch07;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;
    private final int THRESHOLD = 10000;

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    @Override
    protected Long compute() {
        int len = end - start;
        if(len < THRESHOLD){
            return computeSequentially();
        }

        int mid = start + len/2;

        ForkJoinSumCalculator leftCalculator = new ForkJoinSumCalculator(numbers, start, mid);
        ForkJoinTask<Long> leftTask = leftCalculator.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, mid, end);
        Long rightSum = rightTask.compute();
        Long leftSum = leftTask.join();

        return rightSum + leftSum;

    }


    private long computeSequentially(){
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
