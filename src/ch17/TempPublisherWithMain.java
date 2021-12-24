package ch17;

import java.util.concurrent.Flow;

public class TempPublisherWithMain {
    public static void main(String[] args) {
        getTemperatures("서울").subscribe(new TempSubscriber());
        getTemperatures("인천").subscribe(new TempSubscriber());
    }

    //functional interface
    //subscriber가 구독을 신청하면 = subscribe
    private static Flow.Publisher<TempInfo> getTemperatures(String town){
        return subscriber -> subscriber.onSubscribe(
                //subsciption을 돌려주는 메서드를 구현.
                new TempSubscription((Flow.Subscriber<TempInfo>) subscriber, town));
    }
}
