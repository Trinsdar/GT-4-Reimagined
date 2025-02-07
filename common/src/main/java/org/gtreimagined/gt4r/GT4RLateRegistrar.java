package org.gtreimagined.gt4r;

import muramasa.antimatter.AntimatterMod;
import muramasa.antimatter.event.MaterialEvent;
import muramasa.antimatter.registration.RegistrationEvent;
import muramasa.antimatter.registration.Side;
import muramasa.antimatter.util.AntimatterPlatformUtils;

public class GT4RLateRegistrar extends AntimatterMod {
    public GT4RLateRegistrar(){
        super();
        if (AntimatterPlatformUtils.INSTANCE.isFabric()){
            this.onRegistrarInit();
        }
    }
    @Override
    public String getId() {
        return "gt4r-late";
    }

    @Override
    public void onRegistrationEvent(RegistrationEvent event, Side side) {

    }

    @Override
    public void onMaterialEvent(MaterialEvent event) {
    }

    @Override
    public int getPriority() {
        return  Integer.MIN_VALUE;
    }
}
