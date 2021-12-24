package ch15;

import java.util.concurrent.TimeUnit;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {

        //스레드를 직접만들고 태스크를 할당한후 join해서 기달리게 한다
        Result result = new Result();
        Thread t1 = new Thread(()->
        {
            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.left++;
            }
        });
        Thread t2 = new Thread(()->
        {
            for (int i = 0; i < 100; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                result.right--;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("result left : "+  result.left);
        System.out.println("result right : "+  result.right);
    }

    private static class Result{
        private int left;
        private int right;

    }
}
