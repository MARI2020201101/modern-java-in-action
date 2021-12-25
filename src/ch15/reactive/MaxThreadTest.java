package ch15.reactive;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxThreadTest {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < Long.MAX_VALUE; i++) {
            new Thread(()->{
                System.out.println("new Thread : " + counter.addAndGet(1));
                try {
                    Thread.sleep(1000000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
