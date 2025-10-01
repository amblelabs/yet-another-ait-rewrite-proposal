package dev.drtheo.yaar.example.event;

import dev.drtheo.yaar.event.TEvent;
import dev.drtheo.yaar.event.TEvents;
import dev.drtheo.yaar.Tardis;

public record SomeTardisEvent(Tardis tardis) implements TEvent.Notify<TardisEvents> {
    @Override
    public TEvents.Holder<TardisEvents> handler() {
        return TardisEvents.HOLDER;
    }

    @Override
    public void handle(TardisEvents handler) {
        handler.onSomething(tardis);
    }
}
