package dev.drtheo.yaar.data;

import com.google.gson.JsonElement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;

public interface TData<Self extends TData<Self>> {

    Holder<Self> holder();

    default int index() {
        return holder().index();
    }

    class CodecBacked<T extends TData<T>> extends Holder<T> {

        private final Codec<T> codec;

        public CodecBacked(Codec<T> codec) {
            this.codec = codec;
        }

        @Override
        public T decode(JsonElement element) {
            // FIXME: this sucks and is temp
            return codec.decode(JsonOps.INSTANCE, element).get().left().get().getFirst();
        }

        @Override
        public JsonElement encode(T t) {
            // FIXME: this sucks and is temp
            return codec.encode(t, JsonOps.INSTANCE, null).get().left().get();
        }
    }

    abstract class Holder<T extends TData<T>> {

        private int index;

        public int index() {
            return index;
        }

        public void index(int index) {
            this.index = index;
        }

        public abstract T decode(JsonElement element);

        public abstract JsonElement encode(T t);
    }
}
