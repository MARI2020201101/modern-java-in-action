package ch15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFfuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int x = 1337;
        CompletableFuture<Integer> a = new CompletableFuture<>();
        executorService.submit(()->a.complete(work1(x)));
        int b = work2(x);
        System.out.println(a.get() + " , " + b);

        executorService.shutdown();
    }

    public static int work1(int a){
        System.out.println("im working hard1!!!");
        return ++a;
    }
    public static int work2(int b){
        System.out.println("im working hard2!!!");
        return --b;
    }
}
