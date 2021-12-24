package ch16;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ShopConsumerV3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ShopV3 shop = new ShopV3("best shop!");
        List<String> shopPrices = shop.findPrices(ShopV3.Product.APPLE);
        System.out.println(shopPrices);

        System.out.println(Runtime.getRuntime().availableProcessors());

    }

}
