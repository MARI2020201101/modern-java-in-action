package ch17;

import java.util.concurrent.Flow;

public class TempProcessorEx {
    public static void main(String[] args) {
        getTempCelsius("대구").subscribe(new TempSubscriber());
    }

    private static Flow.Publisher<TempInfo> getTempCelsius(String town){
        return subscriber -> {
            //subscribe 메서드를 람다로 구현한다.
            TempProcessor processor = new TempProcessor();
            processor.subscribe(subscriber);
            processor.onSubscribe(new TempSubscription(processor, town));
        };
    }
}
