package trinsdar.gt4r.tile.multi;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.machine.BlockMultiMachine;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.tile.multi.TileEntityMultiMachine;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.Tags;
import trinsdar.gt4r.Ref;
import trinsdar.gt4r.data.Machines;

import java.util.ArrayList;
import java.util.List;

public class TileEntityCharcoalPit extends TileEntityMultiMachine<TileEntityCharcoalPit> {
    List<BlockPos> logPositions;

    public TileEntityCharcoalPit(Machine type) {
        super(type);
    }

    private boolean isCovered(BlockPos pos) {
        return world.getBlockState(pos).getMaterial() == Material.EARTH
                || world.getBlockState(pos).getMaterial() == Material.ORGANIC
                || world.getBlockState(pos).getBlock() == AntimatterAPI.get(BlockMultiMachine.class,Machines.CHARCOAL_PIT.getId() + "_" + Tier.LV.getId(), Ref.ID) || isLog(pos);
    }

    private boolean isLog(BlockPos pos) {
        return world.getBlockState(pos).isIn(BlockTags.LOGS);
    }

    private List<BlockPos> getLogs() {
        return new ArrayList<>();
        //return AabbUtil.getTargets(world, this.pos, 256, filter, true, false, RotationList.ALL);
    }
}
