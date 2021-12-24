package ch15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        Result result = new Result();
        Future<?> result1 = service.submit(() ->
        {
            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.left++;
            }
        });
        Future<?> result2 = service.submit(() ->
        {
            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.right--;
            }
        });

        System.out.println("result left : " + result1);
        System.out.println("result right : " + result2);
        //찍히는건 . 일찍 찍히네.. 메인이 안기달려줌.. (void 메서드 라서??) 
        service.shutdown();
    }

    private static class Result{
        private int left;
        private int right;

    }
}
