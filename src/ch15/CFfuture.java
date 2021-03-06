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

    //아... 뭔가 이게 아닌거 같은데.... 자료구조랑 알고리즘이 훨씬 재밌어....
    //뭔가...으으음~~~~~ 확 와닿지가 . 않네.
    //뼈를 건드리고 싶은디~
    //자바는 자바인데... 장님 코끼리 다리 만지는 기분이네....
}
