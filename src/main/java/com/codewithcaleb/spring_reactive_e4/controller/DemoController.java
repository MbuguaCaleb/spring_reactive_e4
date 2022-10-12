package com.codewithcaleb.spring_reactive_e4.controller;

import com.codewithcaleb.spring_reactive_e4.subscribers.DemoSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.stream.Stream;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo(){

        //Lesson One

        //1.Creating a Publisher
        //creating a Flux
        var f1=Flux.just(1,2,3,4,5,6);

        //Performing Operations of A Publisher
        //do onNext is when i want to perform a pipeline Operation
        //f1.doOnNext(n-> System.out.println(n));

        //if i do not have a Subscriber Nobody consumes the Values
        //There are instances where spring creates a Subscriber for us,for instance when i return a
        //Flux from my controller but this is not the case when i am creating my Own Publisher

        //I Must create a Subscriber to Listen to myEvents
       // f1.doOnNext(n-> System.out.println(n)).subscribe(c-> System.out.println(c));


        //simpler syntax
        //f1.subscribe(c-> System.out.println(c));


        //I May want to have a custom subscriber in many cases where i write my Logic
        //I may want to add more customized Logic Once i Subscribe
        //Custom Subscriber
        f1.doOnNext(c->{throw new RuntimeException("No");}).subscribe(new DemoSubscriber());

    }
}
