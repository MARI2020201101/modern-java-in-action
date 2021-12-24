package ch16;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombineEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ShopV2 shopV2 = new ShopV2("Fast shop!");
        CompletableFuture<Double> prices =
                CompletableFuture.supplyAsync(()->shopV2.getPrice("자바")) //CompletableFuture 홀더에 넣고 async로 실행
                        .thenCombine(CompletableFuture.supplyAsync(()->shopV2.getPrice("파이썬")), //다른 메서드를 async로 실행
                                (p1,p2) -> p1 * p2 ); //그 결과를 하나로 합친다
        System.out.println("price : " + prices.get()); //기다리는 동안 - 메인메서드는 바로반환. 논블로킹 -
    }
}
