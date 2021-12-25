package ch15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService service = Executors.newFixedThreadPool(Integer.MAX_VALUE);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.submit(
                    ()-> {try {
                            System.out.println("new Thread : " + counter.addAndGet(1));
                            Thread.currentThread().join();
                        } catch (InterruptedException e) {}});
        }
    }
}
