package dev.drtheo.yaar;

import dev.drtheo.yaar.data.TData;
import dev.drtheo.yaar.data.TDataRegistry;
import dev.drtheo.yaar.data.DataResolveError;

import java.util.UUID;
import java.util.function.Consumer;

public class Tardis {

    private final UUID id;
    private final TData<?>[] data = new TData[TDataRegistry.size()];

    private final Object lock = new Object();

    public Tardis() {
        this(UUID.randomUUID());
    }

    public Tardis(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void attach(TData<?> data) {
        synchronized(lock) {
            this.data[data.index()] = data;
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends TData<T>> T get(TData.Holder<T> holder) {
        return (T) data[holder.index()];
    }

    public <T extends TData<T>> T resolve(TData.Holder<T> holder) {
        T result = this.get(holder);

        if (result == null)
            throw new DataResolveError();

        return result;
    }

    public void forEachData(Consumer<TData<?>> consumer) {
        for (TData<?> data : this.data) {
            consumer.accept(data);
        }
    }
}
