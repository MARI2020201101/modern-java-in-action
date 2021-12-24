package ch15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CFfutureV3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int x = 1337;

        CompletableFuture<Integer> a = new CompletableFuture<>();
        CompletableFuture<Integer> b = new CompletableFuture<>();
        CompletableFuture<Integer> c = a.thenCombine(b,(y,z) -> y + z);
        //결합한 새로운 completable future... 어떤점이?? 조은건가.,,,,,,,,
        //병렬수행을 하면서도. 블로킹안한다는 점?

        executorService.submit(()->a.complete(work1(x)));
        executorService.submit(()-> b.complete(work2(x)));

        System.out.println(c.get());

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
