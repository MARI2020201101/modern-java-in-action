package ch15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
        work1();
        String t1 = Thread.currentThread().getName();
        Thread.State s1 = Thread.currentThread().getState();
        System.out.println(t1 + "  : " + s1);
//        s.schedule(()->work2(),3, TimeUnit.SECONDS); 일케 써도 되고.

        s.schedule(ScheduledExecutorServiceExample::work2, 3, TimeUnit.SECONDS);
        String t2 = Thread.currentThread().getName();
        Thread.currentThread().join(3500);
        Thread.State s2 = Thread.currentThread().getState();
        System.out.println(t2 + "  : " + s2);
        s.shutdown();
    }



    public static void work1(){
        System.out.println("im working hard1!!!");
    }
    public static void work2(){
        System.out.println("im working hard2!!!");
    }

}
