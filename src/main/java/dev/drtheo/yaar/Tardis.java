package dev.drtheo.yaar;

import dev.drtheo.yaar.data.TData;
import dev.drtheo.yaar.data.TDataRegistry;
import dev.drtheo.yaar.data.DataResolveError;
import dev.drtheo.yaar.util.SparseSet;

public class Tardis {

    private final SparseSet<TData<?>> data = new SparseSet<>(TDataRegistry.size());

    public void attach(TData<?> data) {
        this.data.add(data.index(), data);
    }

    @SuppressWarnings("unchecked")
    public <T extends TData<T>> T get(TData.Holder<T> holder) {
        return (T) data.get(holder.index());
    }

    public <T extends TData<T>> T resolve(TData.Holder<T> holder) {
        T result = this.get(holder);

        if (result == null)
            throw new DataResolveError();

        return result;
    }
}
