package org.gtreimagined.gt4r.events;

import muramasa.antimatter.tool.IAntimatterTool;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;

import static muramasa.antimatter.data.AntimatterDefaultTools.PICKAXE;
import static org.gtreimagined.gtcore.data.GTCoreTools.DRILL;

public class CommonEvents {
    @SuppressWarnings("NoTranslation")
    public static void onRightlickBlock(Player player, InteractionHand hand, boolean server){
        if (hand == InteractionHand.OFF_HAND && server){
            if (player.getMainHandItem().getItem() instanceof IAntimatterTool && (((IAntimatterTool)player.getMainHandItem().getItem()).getAntimatterToolType() == PICKAXE || ((IAntimatterTool)player.getMainHandItem().getItem()).getAntimatterToolType() == DRILL) && (player.getOffhandItem().getItem() == Items.TORCH || player.getOffhandItem().getItem() == Items.SOUL_TORCH)){
                player.sendMessage(new TranslatableComponent("message.gt4r.pickaxe_torch_right_click"), player.getUUID());
            }
        }
    }
}
