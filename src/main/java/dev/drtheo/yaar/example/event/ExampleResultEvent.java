package dev.drtheo.yaar.example.event;

import dev.drtheo.yaar.data.DataResolveError;
import dev.drtheo.yaar.event.TEvent;
import dev.drtheo.yaar.event.TEvents;

public class ExampleResultEvent implements TEvent.Result<TardisEvents, ExampleResultEvent.Interaction> {

    private Interaction result;

    public Interaction handle(TardisEvents handler) throws DataResolveError {
        return handler.withResult();
    }

    @Override
    public TEvents.BaseHolder<TardisEvents> handler() {
        return TardisEvents.HOLDER;
    }

    @Override
    public void handleAll(Iterable<TardisEvents> subscribed) {
        for (TardisEvents handler : subscribed) {
            Interaction interaction = TEvent.handleSilent(this, handler, () -> this.handle(handler), Interaction.CONTINUE);

            if (interaction == Interaction.CONTINUE)
                continue;

            this.result = interaction;
            break;
        }
    }

    @Override
    public Interaction result() {
        return result;
    }

    public enum Interaction {
        CONTINUE,
        FAIL,
        SUCCESS;
    }
}
