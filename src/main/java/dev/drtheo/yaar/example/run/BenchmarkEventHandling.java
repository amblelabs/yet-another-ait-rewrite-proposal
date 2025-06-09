package dev.drtheo.yaar.example.run;

import dev.drtheo.yaar.event.TEventsRegistry;
import dev.drtheo.yaar.handler.THandlerRegistry;
import dev.drtheo.yaar.example.AnotherHandler;
import dev.drtheo.yaar.example.ExampleHandler;
import dev.drtheo.yaar.example.event.DummyEvent;
import dev.drtheo.yaar.example.event.ExampleEvents;

public class BenchmarkEventHandling {

    public static void main(String[] args) {
        // event handler type registration
        TEventsRegistry.register(ExampleEvents.HOLDER);

        // component registration
        ExampleHandler exHandler = new ExampleHandler();
        THandlerRegistry.register(exHandler);

        AnotherHandler anotherHandler = new AnotherHandler();
        THandlerRegistry.register(anotherHandler);

        // (base AIT only, freezes the registry)
        THandlerRegistry.freeze();

        // event handling
        long total = 0;

        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 1_000_000; j++) {
                THandlerRegistry.handle(new DummyEvent());
            }
            total += System.currentTimeMillis() - start;
        }

        System.out.println("Total time: " + total + "ms; Avg: " + total / 10 + "ms");
    }
}
