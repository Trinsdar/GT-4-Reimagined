package trinsdar.gt4r.gui.slots;

import muramasa.antimatter.blockentity.BlockEntityMachine;
import muramasa.antimatter.capability.IGuiHandler;
import muramasa.antimatter.capability.IMachineHandler;
import muramasa.antimatter.gui.SlotType;
import muramasa.antimatter.gui.slot.AbstractSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import tesseract.api.item.ExtendedItemContainer;
import trinsdar.gt4r.blockentity.multi.BlockEntityIndustrialBlastFurnace;
import trinsdar.gt4r.blockentity.single.BlockEntitySmelter;
import trinsdar.gt4r.data.GT4RItems;
import trinsdar.gt4r.data.Machines;
import trinsdar.gt4r.data.RecipeMaps;

public class SlotCoil extends AbstractSlot<SlotCoil> {
    public SlotCoil(SlotType<SlotCoil> type, IGuiHandler tile, ExtendedItemContainer stackHandler, int index, int xPosition, int yPosition) {
        super(type, tile, stackHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        if (holder instanceof BlockEntitySmelter){
            return RecipeMaps.SMELTER_COILS.acceptsItem(stack);
        }
        BlockEntityMachine<?> m = (BlockEntityMachine<?>) holder;
        return stack.getItem() == GT4RItems.KanthalHeatingCoil || stack.getItem() == GT4RItems.NichromeHeatingCoil || (m.getMachineType() == Machines.PYROLYSIS_OVEN && stack.getItem() == GT4RItems.CupronickelHeatingCoil);
    }

    @Override
    public boolean mayPickup(Player playerIn) {
        return true;
    }

    @Override
    public int getMaxStackSize() {
        if (holder instanceof BlockEntitySmelter){
            return 6;
        }
        return 4;
    }

    @Override
    public int getMaxStackSize(@NotNull ItemStack stack) {
        if (holder instanceof BlockEntitySmelter){
            return 6;
        }
        return 4;
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (holder instanceof IMachineHandler) ((IMachineHandler)holder).onMachineEvent(BlockEntityIndustrialBlastFurnace.BFEvent.SLOT_COIL_CHANGED, this.getItem());
    }
}
