package dev.drtheo.yaar.handler;

public interface THandler {

    default <T> T handler() {
        return null;
    }
}
