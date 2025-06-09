package dev.drtheo.yaar.data;

import java.util.*;

public class TDataRegistry {

    private static boolean frozen;

    private static final List<TData.Holder<?>> comps = new ArrayList<>();

    public static void register(TData.Holder<?> holder) {
        if (frozen)
            throw new IllegalStateException("Already frozen");

        holder.index(comps.size());
        comps.add(holder);
    }

    public TData.Holder<?> get(int index) {
        return comps.get(index);
    }

    public static int size() {
        return comps.size();
    }

    public static void freeze() {
        frozen = true;
    }
}
