package ch16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class ShopV2 {
    String name;
    private Random random = new Random();

    public ShopV2(String name){
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

    //훨씬 깔끔하게 구현할수가 있다....헐..
    public Future<Double> getPriceAsyncSupplier(String product){
        return CompletableFuture.supplyAsync(()->calculatePrice(product));
    }


    public Future<Double> getPriceAsyncException(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()-> {
            try{
                double price = calculatePrice(product);
                futurePrice.complete(price);
                throw new RuntimeException("계산도중에러발생!!");
            }catch (Exception e){
                futurePrice.completeExceptionally(e);

            }
        }).start();
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
