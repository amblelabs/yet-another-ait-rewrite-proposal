package dev.drtheo.yaar.example;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.drtheo.yaar.data.TData;

public class StatsData implements TData<StatsData> {

    public static final Holder<StatsData> ID = new CodecBacked<>(
            RecordCodecBuilder.<StatsData>create(instance -> instance.group(
                    Codec.STRING.fieldOf("name").forGetter(StatsData::getName)
            ).apply(instance, StatsData::new))
    );

    private String name;

    public StatsData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Holder<StatsData> holder() {
        return ID;
    }
}
