**Creating a Publisher**

```yaml
         <-------subscription----------------> 
Publisher------------------------------------Subscriber


(A)Creating a Publisher
         
 //Flux is just an implementation of the Publisher
 //        Flux<Integer> f2 = Flux.just(2,2,2);
 //        Publisher<Integer> f3 = Flux.just(6,7,8);

 //        var f2 = Flux.fromStream(Stream.of(1,2,3,4,5,6,7));
 //        var f3 = Flux.fromIterable(Set.of(1,2,3,4,5,6));
 //
 //
 //        //Creating a Mono
 //
 //        var m1 = Mono.just(1);



(b)Performing Operations on a Publisher


```


**CUSTOM SUBSCRIBER LIFE CYCLE METHODS**

```yaml

Methods in the Subscriber are utility methods that the publisher calls.


(a)onSubscribe method is called automatically once we make a subscription
Inside the onSubscribe method we request for a value

The first method that a publisher will call upon the subscribe 
request.


(b)OnNext Method is called after the request..
(RULE OF THUMB)

(C)On Error

Communicates if there is a error on the publisher side.

On error is called by the publisher incase there is an error on the
publisher side,not the subscriber side.

The onError method does not handle errors or exceptions on the Subscriber side.

It is a way that the publisher notifies the subscriber if any
exception happens on their side.

(d)OnComplete

Tells the Subscriber there are no more values.

public void onSubscribe(Subscription subscription) {
            System.out.println("Subscribed");
            //from the subscription i can request a Value
            //Remember that publisher does not push values to the Subscriber
            //its always the other way round
            this.subscription = subscription;
            subscription.request(1);
        }

        //Called by a Publisher after a successful subscription
        //To provide a Value to the Subscriber the Publisher calls the OnNext Method
        @Override
        public void onNext(Integer integer) {
            System.out.println("On Next " + integer);
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
    });

    
    //There is a very big difference between WebFlux and the Java Stream api
    //In Java Stream Events are pushed by the stream
    //in webflux it is the subscriber that requests for the event


```


**BackPressure**

```yaml


It is a concept whereBy a Subscriber in its own pace asks for elements from a Publisher.

You can choose to ask One at a time, two at a time,

Therefore we can have a subscriber having control of how many elements it requests from a publisher.


The subscriber asks for values...


It is not forced to have values.


```


*N/B*

```yaml


The publisher at least has access to the subscriber through the 
subscribe method,

The subscribe method is a method it provides such that
you can be able to subscribe from it.

f1.subscribe(new DemoSubscriber());


Once communication is established, the subscriber now receives
communication from Publisher through the subscription.


The most important thing to the subscriber is the
subscription, that is what it uses to communicate.


```


**Subsscription Contract**

```yaml

It has two methods,

1.request


2.Cancel


I can therefore cancel a subscription.


```

**Conclusion**

```yaml


There are three main reactive programming contracts,

(a)Publisher


(b)Subscriber


(c)Subscription

1.There are Multiple methods we can call on a Publisher's pipeline.


2.There are 4 methods on the Subscriber Pipeline

3.There are 2 methods in the Subscription Contract

```