package org.gtreimagined.gt4r.blockentity.multi;

import muramasa.antimatter.blockentity.multi.BlockEntityMultiMachine;
import muramasa.antimatter.machine.types.Machine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityOilDrillingRig extends BlockEntityMultiMachine<BlockEntityOilDrillingRig> {

    public BlockEntityOilDrillingRig(Machine<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}