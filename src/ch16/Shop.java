package ch16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
    String name;
    private Random random = new Random();

    public Shop(String name){
        this.name= name;
    }

    public double getPrice(String product) {
        //데이터베이스에서 상품 가격정보를 읽어온다
        //외부서비스에 접근해서 할인정보를 가져온다
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()-> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    public Future<Double> getPriceAsyncV2(String product){
        long start = System.nanoTime();
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()-> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        long end = System.nanoTime();
        System.out.println("ellasped time : " +(end-start));
        return futurePrice;
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
