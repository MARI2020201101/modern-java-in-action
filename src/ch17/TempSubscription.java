package ch17;

import java.util.concurrent.Flow;

public class TempSubscription implements Flow.Subscription {
    private final Flow.Subscriber<TempInfo> subscriber;
    private final String town;

    public TempSubscription(Flow.Subscriber<TempInfo> subscriber, String town) {
        this.subscriber = subscriber;
        this.town = town;
    }

    @Override
    public void request(long n) {//request 를 호출할때에만 데이터를 줌으로써 역압을 조절한다.
        for (int i = 0; i < n; i++) {
            try{//subscriber 에게 데이터를 전달한다.
                subscriber.onNext(TempInfo.fetch(town));
            }catch(Exception e){
                //데이터 전송 실패시 에러를 전달한다.
                subscriber.onError(e);
            }
        }
    }

    @Override
    public void cancel() {
        //구독을 종료하였음을 나타낸다.
        subscriber.onComplete();
    }
}
