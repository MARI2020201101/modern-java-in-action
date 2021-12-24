package ch16;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ShopConsumerV2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ShopV2 shop = new ShopV2("best shop!");
        String product = "modern java in action";
        Future<Double> price = shop.getPriceAsyncException(product);
        System.out.println("price of [" + product + "] : " + price.get());
        System.out.println();
        Future<Double> supplierPrice = shop.getPriceAsyncSupplier(product);
        System.out.println("price of [" + product + "] : " + supplierPrice.get());
    }
}
