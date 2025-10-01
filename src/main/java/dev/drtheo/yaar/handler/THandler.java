package dev.drtheo.yaar.handler;

import dev.drtheo.yaar.event.TEvent;
import dev.drtheo.yaar.event.TEvents;

public interface THandler {

    /**
     * @implNote Never changes value, just a marker/stub value for final fields.
     * @return Always {@code null}.
     */
    default <T> T handler() {
        return null;
    }

    /**
     * Redirects to {@link TEvents#handle(TEvent)}
     */
    default <T extends TEvents> void handle(TEvent<T> event) {
        TEvents.handle(event);
    }

    /**
     * Redirects to {@link TEvents#handle(TEvent.Result)}
     */
    default <T extends TEvents, R> R handle(TEvent.Result<T, R> event) {
        return TEvents.handle(event);
    }
}
