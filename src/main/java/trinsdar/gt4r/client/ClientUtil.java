package trinsdar.gt4r.client;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import trinsdar.gt4r.data.GT4RData;

@OnlyIn(Dist.CLIENT)
public class ClientUtil {
    public static void registerThrowingWeaponPropertyOverrides(Item throwingWeapon) {
        ItemModelsProperties.register(throwingWeapon, new ResourceLocation("throwing"), (stack, world, living) -> {
            if (living != null && stack.sameItem(living.getUseItem())) {
                return living.getUseItemRemainingTicks() > 0 ? 1.0F : 0.0F;
            } else {
                return 0.0F;
            }
        });
    }

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(GT4RData.SPEAR_ENTITY_TYPE, m -> new SpearRenderer(m, Minecraft.getInstance().getItemRenderer()));
    }
}
