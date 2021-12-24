package ch15.reactive;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class SimpleCell implements Flow.Publisher<Integer> , Flow.Subscriber<Integer> {
    String name;
    int value = 0;
    List<Flow.Subscriber> subscribers = new ArrayList<>();

    public SimpleCell(String name){
        this.name=name;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(Integer item) {
        this.value = item;
        subscribers.forEach(s -> notifyAllSubscribers(value));
    }

    private void notifyAllSubscribers(int value) {
        System.out.println("****\nnew value!!! : "+value+" \n****");

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }


}
