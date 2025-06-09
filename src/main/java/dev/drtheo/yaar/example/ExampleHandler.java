package dev.drtheo.yaar.example;

import dev.drtheo.yaar.handler.Resolve;
import dev.drtheo.yaar.handler.THandler;
import dev.drtheo.yaar.Tardis;
import dev.drtheo.yaar.example.event.ExampleEvents;
import dev.drtheo.yaar.example.event.TardisEvents;

public class ExampleHandler implements THandler, ExampleEvents, TardisEvents {

    @Resolve
    private final AnotherHandler another = handler();

    @Override
    public void onHelloWorld(String text) {
        System.out.println("HIII");
        another.displayText(text);
    }

    @Override
    public void onSomething(Tardis tardis) {
        StatsData stats = tardis.resolve(StatsData.ID);

        System.out.println("TARDIS name: '" + stats.getName() + "'");
    }
}
