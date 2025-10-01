package dev.drtheo.yaar.example.run;

import dev.drtheo.yaar.data.TDataRegistry;
import dev.drtheo.yaar.event.TEvents;
import dev.drtheo.yaar.event.TEventsRegistry;
import dev.drtheo.yaar.example.event.ExampleResultEvent;
import dev.drtheo.yaar.handler.THandlerRegistry;
import dev.drtheo.yaar.Tardis;
import dev.drtheo.yaar.example.AnotherHandler;
import dev.drtheo.yaar.example.ExampleHandler;
import dev.drtheo.yaar.example.StatsData;
import dev.drtheo.yaar.example.event.ExampleEvents;
import dev.drtheo.yaar.example.event.SomeTardisEvent;
import dev.drtheo.yaar.example.event.TardisEvents;

public class AITMod {

    public void onInitialize() {
        // event handler type registration
        TEventsRegistry.register(ExampleEvents.HOLDER);
        TEventsRegistry.register(TardisEvents.HOLDER);

        // (base AIT only, must happen before handler registration)
        TEventsRegistry.freeze();

        // data registration
        TDataRegistry.register(StatsData.ID);

        // component registration
        ExampleHandler exHandler = new ExampleHandler();
        THandlerRegistry.register(exHandler);

        AnotherHandler anotherHandler = new AnotherHandler();
        THandlerRegistry.register(anotherHandler);

        // (base AIT only, freezes the registry)
        THandlerRegistry.freeze();

        // event handling
        Tardis tardis = new Tardis();
        tardis.attach(new StatsData("peanut"));

        TEvents.handle(new SomeTardisEvent(tardis));

        System.out.println(TEvents.handle(new ExampleResultEvent()));
    }

    public static void main(String[] args) {
        new AITMod().onInitialize();
    }
}
