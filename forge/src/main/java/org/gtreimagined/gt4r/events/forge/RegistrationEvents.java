package org.gtreimagined.gt4r.events.forge;

import muramasa.antimatter.event.forge.AntimatterCraftingEvent;
import muramasa.antimatter.event.forge.AntimatterProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.gtreimagined.gt4r.GT4RRef;
import org.gtreimagined.gt4r.events.AntimatterEvents;

@Mod.EventBusSubscriber(modid = GT4RRef.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistrationEvents {

    @SubscribeEvent
    public static void onProviders(AntimatterProvidersEvent event){
        AntimatterEvents.onProviders(event.getEvent());
    }

    @SubscribeEvent
    public static void registerCraftingLoaders(AntimatterCraftingEvent event){
        AntimatterEvents.registerCraftingLoaders(event.getEvent());
    }
}
