package trinsdar.gt4r.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import trinsdar.gt4r.data.GT4RData;

@Environment(EnvType.CLIENT)
public class ClientUtil {
    public static void registerThrowingWeaponPropertyOverrides(Item throwingWeapon) {
        ItemProperties.register(throwingWeapon, new ResourceLocation("throwing"), (stack, level, living, seed) -> {
            if (living != null && stack.sameItem(living.getUseItem())) {
                return living.getUseItemRemainingTicks() > 0 ? 1.0F : 0.0F;
            } else {
                return 0.0F;
            }
        });
    }

    public static void registerEntityRenders() {
        EntityRenderers.register(GT4RData.SPEAR_ENTITY_TYPE, m -> new SpearRenderer(m, Minecraft.getInstance().getItemRenderer()));
    }
}