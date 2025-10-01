package dev.drtheo.yaar.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import mock.Identifier;

import java.io.IOException;

public interface TData<Self extends TData<Self>> {

    Holder<Self> holder();

    default int index() {
        return holder().index();
    }

    class CodecBacked<T extends TData<T>> extends Holder<T> {

        private final Codec<T> codec;

        public CodecBacked(Identifier id, Codec<T> codec) {
            super(id);
            this.codec = codec;
        }

        @Override
        public T decode(JsonObject element) {
            // FIXME: this sucks and is temp
            return codec.decode(JsonOps.INSTANCE, element).get().left().get().getFirst();
        }

        @Override
        public JsonObject encode(T t) {
            // FIXME: this sucks and is temp
            return codec.encode(t, JsonOps.INSTANCE, null).get().left().get().getAsJsonObject();
        }
    }

    class GsonBacked<T extends TData<T>> extends Holder<T> {

        private static final Gson GSON = new GsonBuilder()
                .registerTypeAdapter(Identifier.class, new TypeAdapter<>() {
                    @Override
                    public void write(JsonWriter out, Object value) throws IOException {
                        out.jsonValue(value.toString());
                    }

                    @Override
                    public Object read(JsonReader in) throws IOException {
                        return Identifier.tryParse(in.nextString());
                    }
                })
                .create();

        private final Class<T> clazz;

        public GsonBacked(Identifier id, Class<T> clazz) {
            super(id);
            this.clazz = clazz;
        }

        @Override
        public T decode(JsonObject element) {
            return GSON.fromJson(element, clazz);
        }

        @Override
        public JsonObject encode(T t) {
            return GSON.toJsonTree(t).getAsJsonObject();
        }
    }

    abstract class Holder<T extends TData<T>> {

        private int index;
        private final Identifier id;

        public Holder(Identifier id) {
            this.id = id;
        }

        public Identifier id() {
            return id;
        }

        public int index() {
            return index;
        }

        public void index(int index) {
            this.index = index;
        }

        public abstract T decode(JsonObject element);

        public abstract JsonObject encode(T t);
    }
}
