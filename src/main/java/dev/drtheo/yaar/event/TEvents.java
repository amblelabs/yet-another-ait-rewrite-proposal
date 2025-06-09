package dev.drtheo.yaar.event;

import dev.drtheo.yaar.data.DataResolveError;
import dev.drtheo.yaar.handler.THandler;

import java.util.ArrayList;
import java.util.List;

public interface TEvents {

    record Holder<T extends TEvents>(Class<T> clazz, List<T> handlers) {

        public Holder(Class<T> clazz) {
            this(clazz, new ArrayList<>());
        }

        public void subscribe(THandler handler) {
            if (!this.isApplicable(handler))
                throw new IllegalArgumentException("you're crazy");

            handlers.add((T) handler);
        }

        public void handle(TEvent<T> event) {
            for (T handler : handlers) {
                try {
                    event.handle(handler);
                } catch (DataResolveError ignored) {
                    // ignored
                } catch (Throwable e) {
                    System.err.println("Failed to handle event '" + event.getClass() + " for handler " + handler.getClass());
                }
            }
        }

        public boolean isApplicable(THandler handler) {
            return clazz.isInstance(handler);
        }
    }
}
