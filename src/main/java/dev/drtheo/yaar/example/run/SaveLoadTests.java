package dev.drtheo.yaar.example.run;

import dev.drtheo.yaar.Tardis;
import dev.drtheo.yaar.data.TDataRegistry;
import dev.drtheo.yaar.example.data.DoorData;
import dev.drtheo.yaar.example.data.TravelData;
import dev.drtheo.yaar.io.TardisFileManager;

import java.io.IOException;
import java.nio.file.Path;

public class SaveLoadTests {

    public static void main(String[] args) throws IOException {
        TDataRegistry.register(DoorData.ID);
        TDataRegistry.register(TravelData.ID);

        TardisFileManager manager = new TardisFileManager();

        Tardis tardis = manager.read(Path.of("reference/tardis_save.json"));

        tardis.forEachData(System.out::println);
    }
}
