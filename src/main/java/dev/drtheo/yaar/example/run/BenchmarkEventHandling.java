package dev.drtheo.yaar.example.run;

import dev.drtheo.yaar.event.TEvents;
import dev.drtheo.yaar.event.TEventsRegistry;
import dev.drtheo.yaar.handler.THandlerRegistry;
import dev.drtheo.yaar.example.AnotherHandler;
import dev.drtheo.yaar.example.ExampleHandler;
import dev.drtheo.yaar.example.event.DummyEvent;
import dev.drtheo.yaar.example.event.ExampleEvents;

import java.io.Reader;
import java.util.Random;
import java.util.Scanner;

public class BenchmarkEventHandling {

    public static void main(String[] args) {
        new Scanner(System.in).nextLine();

        // event handler type registration
        TEventsRegistry.register(ExampleEvents.HOLDER);

        TEventsRegistry.freeze();

        // component registration
        ExampleHandler exHandler = new ExampleHandler();
        THandlerRegistry.register(exHandler);

        AnotherHandler anotherHandler = new AnotherHandler();
        THandlerRegistry.register(anotherHandler);

        // (base AIT only, freezes the registry)
        THandlerRegistry.freeze();

        // imagine this is tardis objects
        Object[] objs = new Object[1000];

        for (int i = 0; i < objs.length; i++) {
            objs[i] = new Random().nextInt();
        }

        // event handling
        long time = System.nanoTime();

        for (int i = 0; i < 24 * 60 * 60 * 20; i++) {
            // simulate tardis.tick() behavior (o = tardis object)
            for (Object o : objs) {
                TEvents.handle(new DummyEvent());
            }
        }

        time = System.nanoTime() - time;

        System.out.println("Total time: " + time / 1_000_000 + "ms; Avg: " + time / (24*60*60*20) + "ns");
    }
}
