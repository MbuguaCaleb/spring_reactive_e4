package com.codewithcaleb.spring_reactive_e4.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DemoSubscriber implements Subscriber<Integer> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        this.subscription = subscription;
        subscription.request(1);
    }

    //To provide a Value to the Subscriber the Publisher calls the OnNext Method
    //The publisher will call the onNext Method after every request
    @Override
    public void onNext(Integer integer) {
        System.out.println("On Next " + integer);
        subscription.request(1);
        if(integer == 3) throw  new RuntimeException("No");
    }

    //It is used by the Publisher to notify the Subscriber incase of any error
    @Override
    public void onError(Throwable throwable) {
        System.out.println("On Error" + throwable);
    }


    //It is used by the Publisher to inform the Subscriber that it has got no more events
    @Override
    public void onComplete() {
        System.out.println("On Complete");
    }
}
