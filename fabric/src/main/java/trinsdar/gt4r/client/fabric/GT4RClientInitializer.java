package trinsdar.gt4r.client.fabric;

import muramasa.antimatter.client.fabric.IAntimatterClientInitializer;
import trinsdar.gt4r.proxy.ClientHandler;

public class GT4RClientInitializer implements IAntimatterClientInitializer {
    @Override
    public void onInitializeClient() {
        ClientHandler.setup();
    }
}
