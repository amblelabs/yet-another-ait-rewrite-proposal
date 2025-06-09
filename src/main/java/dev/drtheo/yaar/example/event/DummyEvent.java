package dev.drtheo.yaar.example.event;

import dev.drtheo.yaar.event.TEvent;
import dev.drtheo.yaar.event.TEvents;

public class DummyEvent implements TEvent<ExampleEvents> {
    @Override
    public TEvents.Holder<ExampleEvents> handler() {
        return ExampleEvents.HOLDER;
    }

    @Override
    public void handle(ExampleEvents handler) {
        handler.onDummyEvent();
    }
}
