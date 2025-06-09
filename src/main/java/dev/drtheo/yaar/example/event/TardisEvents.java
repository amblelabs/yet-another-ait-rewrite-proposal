package dev.drtheo.yaar.example.event;

import dev.drtheo.yaar.event.TEvents;
import dev.drtheo.yaar.Tardis;

public interface TardisEvents extends TEvents {

    Holder<TardisEvents> HOLDER = new Holder<>(TardisEvents.class);

    void onSomething(Tardis tardis);
}
