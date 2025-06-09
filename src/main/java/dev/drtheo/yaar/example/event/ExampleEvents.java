package dev.drtheo.yaar.example.event;

import dev.drtheo.yaar.event.TEvents;

public interface ExampleEvents extends TEvents {

    Holder<ExampleEvents> HOLDER = new Holder<>(ExampleEvents.class);

    void onHelloWorld(String tardis);

    default void onDummyEvent() { }
}
