package dev.drtheo.yaar.event;

public interface TEvent<T extends TEvents> {

    TEvents.Holder<T> handler();
    void handle(T handler);
}
