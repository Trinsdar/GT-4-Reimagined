package org.gtreimagined.gt4r.forge;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.gtreimagined.gt4r.GT4RRef;
import org.gtreimagined.gt4r.GT4Reimagined;
import org.gtreimagined.gt4r.proxy.ClientHandler;
import org.gtreimagined.gt4r.proxy.ServerHandler;

@Mod(GT4RRef.ID)
public class GT4ReimaginedForge {
    public GT4ReimaginedForge(){
        new GT4Reimagined();
        GT4Reimagined.PROXY = DistExecutor.runForDist(() -> ClientHandler::new, () -> ServerHandler::new); // todo: scheduled to change in new Forge
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
    }

    private void clientSetup(final FMLClientSetupEvent e) {
        ClientHandler.setup();
    }

    private void setup(final FMLCommonSetupEvent e) {
    }

    private void serverSetup(final FMLDedicatedServerSetupEvent event){
    }
}
