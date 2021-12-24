package ch16;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ShopConsumer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Shop shop = new Shop("best shop!");
        String product = "modern java in action";
        double price = shop.getPrice(product);
        System.out.println("price of [" + product + "] : " + price); //블로킹
        System.out.println();
        Future<Double> asyncPrice = shop.getPriceAsync(product);
        System.out.println("price of [" + product + "] : " + asyncPrice);//호출된메서드는 바로 반환
        System.out.println("price of [" + product + "] : " + asyncPrice.get());//다시 돌아오면 결과를 콜백처럼 준다
        System.out.println();
        Future<Double> asyncPrice2 = shop.getPriceAsyncV2(product);//바로 반환되므로 시간계산 (cpu연산) 이 먼저 일어난다.
        System.out.println("price of [" + product + "] : " + asyncPrice2.get());
    }
}
