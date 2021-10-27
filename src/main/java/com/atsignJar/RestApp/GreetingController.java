package com.atsignJar.RestApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    private final static String template = "Hello %s";

    @GetMapping("/")
    public String getHello(){
        return "Hello world";
    }

    @GetMapping("/sayHello")
    public Greeting sayHello(){return new Greeting(32,"HELLLOOOO\nCAREEEER DEVSS!!!");}

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Walrd") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }

    @GetMapping("/hello/{name")
    public Greeting hello(@PathVariable String name){
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
}
