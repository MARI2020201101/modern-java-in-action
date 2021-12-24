package ch17;

import java.util.concurrent.Flow;

public class TempProcessor implements Flow.Processor<TempInfo, TempInfo> {
    private Flow.Subscriber<TempInfo> subscriber;

    @Override
    public void subscribe(Flow.Subscriber<? super TempInfo> subscriber) {
        this.subscriber= (Flow.Subscriber<TempInfo>) subscriber;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscriber.onSubscribe(subscription);
    }

    @Override
    public void onNext(TempInfo tempInfo) {
        subscriber.onNext(
                new TempInfo(tempInfo.getTown() ,
                        ((tempInfo.getTemp() -32)*5/9)));
    }

    @Override
    public void onError(Throwable throwable) {
        subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
        subscriber.onComplete();
    }
}
