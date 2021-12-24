package ch16;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ShopV3 {
    String name;
    private Random random = new Random();
    private Set<Product> products = EnumSet.allOf(Product.class);

    public ShopV3(String name){
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(()-> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }

    public List<String> findPrices(Product product){
        return products.stream()
                .map((p) ->" [SHOP : " +getName() + "] "+ product.name())
                .collect(toList());
    }


//    public List<String> findPricesAsync(Product product){
//
////        List<CompletableFuture<String>> list = products.stream()
////                .map((p) ->  CompletableFuture.supplyAsync(() ->
////
////                       getPriceAsync(product.name()))).collect(Collectors.toList());
//        return list.stream().map(CompletableFuture::join).collect(toList());
//    }
    public Future<Double> getPriceAsyncSupplier(String product){
        return CompletableFuture.supplyAsync(()->calculatePrice(product));
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

    public enum Product {
        APPLE, BANANA, WATERMELON;
    }
}
