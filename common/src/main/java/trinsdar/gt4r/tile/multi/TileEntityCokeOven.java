package trinsdar.gt4r.tile.multi;

import muramasa.antimatter.cover.ICover;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.tile.multi.TileEntityBasicMultiMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;
import tesseract.api.TesseractCaps;
import tesseract.api.capability.TesseractGTCapability;
import tesseract.api.gt.IEnergyHandler;

import static net.minecraftforge.fluids.capability.CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY;
import static net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

public class TileEntityCokeOven extends TileEntityBasicMultiMachine<TileEntityCokeOven> {

    public TileEntityCokeOven(Machine<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        /*this.itemHandler = type.has(ITEM) || type.has(CELL) ? LazyOptional.of(() -> new MachineItemHandler<>(this)) : LazyOptional.empty();
        this.fluidHandler = type.has(FLUID) ? LazyOptional.of(() -> new MachineFluidHandler<>(this)) : LazyOptional.empty();
        this.energyHandler = type.has(ENERGY) ? LazyOptional.of(() -> new MachineEnergyHandler<>(this, type.amps(),type.has(GENERATOR))) : LazyOptional.empty();*/
    }

    @Override
    public int maxShares() {
        return 0;
    }

    @Override
    public <T> LazyOptional<T> getCapabilityFromFake(Class<T> cap, BlockPos pos, Direction side, ICover coverPresent) {
        if (cap == IItemHandler.class && itemHandler.isPresent()) return itemHandler.side(side).cast();
        else if (cap == IFluidHandler.class && fluidHandler.isPresent()) return fluidHandler.side(side).cast();
        else if (cap == IEnergyHandler.class && energyHandler.isPresent()) return energyHandler.side(side).cast();
        return LazyOptional.empty();
    }
}
