package ch06;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class PartitioningIsPrime {
    public static void main(String[] args) {

        Map<Boolean, List<Integer>> isPrimePartition =
                IntStream.rangeClosed(2, 100)
                .boxed()
                .collect(partitioningBy(i -> isPrime(i)));

        System.out.println(isPrimePartition);
        System.out.println("--------------------------------------------");
        List<Integer> primeList = isPrimePartition.get(true);
        System.out.println("primes under 100: " + primeList);
    }

    public static boolean isPrime(int n){
        int upperBound = (int)Math.sqrt(n);
        return IntStream.rangeClosed(2,upperBound)
                .noneMatch(i -> n%i == 0);
    }
}
