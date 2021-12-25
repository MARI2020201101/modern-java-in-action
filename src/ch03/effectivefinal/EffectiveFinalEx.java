package ch03.effectivefinal;

import java.util.concurrent.Executors;

public class EffectiveFinalEx {
    public static void main(String[] args) {
        String main = Thread.currentThread().getName();
        System.out.println("main thread name : "+main);

        //main = "mmm";
        Executors.newSingleThreadExecutor().submit(()->{
            String thread = Thread.currentThread().getName();
            System.out.println("another thread name : "+thread);
            System.out.println("another thread name2 : "+main);

        // Variable used in lambda expression should be final or effectively final
        });
    }
}
