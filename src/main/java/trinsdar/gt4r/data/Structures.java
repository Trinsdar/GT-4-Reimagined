package trinsdar.gt4r.data;

import muramasa.antimatter.Data;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.structure.BlockStateElement;
import muramasa.antimatter.structure.FakeTileElement;
import muramasa.antimatter.structure.PatternBuilder;
import muramasa.antimatter.structure.StructureBuilder;
import muramasa.antimatter.util.Dir;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.core.Direction;

import java.util.function.BiFunction;
import java.util.function.Function;

import static muramasa.antimatter.machine.Tier.LV;
import static trinsdar.gt4r.data.GT4RData.*;
import static trinsdar.gt4r.data.Machines.*;

public class Structures {

    /** Special Case Elements **/
    public static BlockStateElement AIR_OR_LAVA = new BlockStateElement("air_or_lava", (w, p, s) -> s.isAir() || s.getFluidState().getType() == Fluids.LAVA/* || s.getBlock() == Blocks.FLOWING_LAVA*/);
    public static BlockStateElement AIR = new BlockStateElement("air", (w, p, s) -> s.isAir());
    public static BlockStateElement WATER = new BlockStateElement("water", (w, p, s) -> s.getFluidState().getType() == Fluids.WATER);


    public static FakeTileElement BRICK = new FakeTileElement(FIRE_BRICKS);
    public static FakeTileElement CASING = new FakeTileElement(STANDARD_MACHINE_CASING);

    public static void initPatterns() {
        COKE_OVEN.setStructurePattern(b -> b
                .of("CCC", "CCC", "CCC").of("CCC", "CAM", "CCC").of(0)
                .at("C", FIRE_BRICKS.defaultBlockState()).at("M", COKE_OVEN, LV, Direction.SOUTH)
                .description(COKE_OVEN.getDisplayName(COKE_OVEN.getFirstTier()))
                .build()
        );
        PatternBuilder builder = new PatternBuilder().of("CCC ", "CCM", "CCC ").of("CCC ", "CLC ", "CCC ").of("CCC ", "CCC ", "CCC ")
                .at("M", PYROLYSIS_OVEN, PYROLYSIS_OVEN.getFirstTier(), Direction.SOUTH).at("C", STANDARD_MACHINE_CASING.defaultBlockState());
        PYROLYSIS_OVEN.setStructurePattern(
                builder.at("L", Blocks.LAVA.defaultBlockState()).description(Blocks.LAVA.getDescriptionId()).build()
        );
        builder = new PatternBuilder().of("CCC", "CCC", "CCC").of("CCC", "CBM", "CCC").of("CCC", "CBC", "CCC").of(2)
                .at("C", FIRE_BRICKS.defaultBlockState()).at("M", PRIMITIVE_BLAST_FURNACE, PRIMITIVE_BLAST_FURNACE.getFirstTier(), Direction.SOUTH);
        PRIMITIVE_BLAST_FURNACE.setStructurePattern(
                builder.at("B", Blocks.AIR.defaultBlockState()).description(Blocks.AIR.getDescriptionId()).build()
        );
        builder = new PatternBuilder().of("CCC ", "CCCM", "CCC ").of("CCC ", "CLC ", "CCC ").of(1).of("CCC ", "CCC ", "CCC ")
                .at("M", BLAST_FURNACE, BLAST_FURNACE.getFirstTier(), Direction.SOUTH);
        BLAST_FURNACE.setStructurePattern(
                builder.at("C", STANDARD_MACHINE_CASING.defaultBlockState()).at("L", Blocks.LAVA.defaultBlockState()).description(STANDARD_MACHINE_CASING.getDescriptionId() + " With " + Blocks.LAVA.getDescriptionId()).build(),
                builder.at("C", REINFORCED_MACHINE_CASING.defaultBlockState()).at("L", Blocks.LAVA.defaultBlockState()).description(REINFORCED_MACHINE_CASING.getDescriptionId() + " With " + Blocks.LAVA.getDescriptionId()).build(),
                builder.at("C", ADVANCED_MACHINE_CASING.defaultBlockState()).at("L", Blocks.LAVA.defaultBlockState()).description(ADVANCED_MACHINE_CASING.getDescriptionId() + " With " + Blocks.LAVA.getDescriptionId()).build()
        );
        VACUUM_FREEZER.setStructurePattern(b -> b
                .of("CCC", "CcC", "CCC").of("CcC", "cAc", "CcC").of(0).of("   ", " M ", "   ")
                .at("M", VACUUM_FREEZER, VACUUM_FREEZER.getFirstTier(), Direction.SOUTH).at("C", REINFORCED_MACHINE_CASING.defaultBlockState()).at("c", ADVANCED_MACHINE_CASING.defaultBlockState())
                .description(VACUUM_FREEZER.getBlockState(VACUUM_FREEZER.getFirstTier()).getDescriptionId())
                .build()
        );
        IMPLOSION_COMPRESSOR.setStructurePattern(b -> b
                .of("cCc", "CCC", "cCc").of("CCC", "CAC", "CCC").of(0).of("   ", " M ", "   ")
                .at("M", IMPLOSION_COMPRESSOR, IMPLOSION_COMPRESSOR.getFirstTier(), Direction.SOUTH).at("C", REINFORCED_MACHINE_CASING.defaultBlockState()).at("c", STANDARD_MACHINE_CASING.defaultBlockState())
                .description(IMPLOSION_COMPRESSOR.getBlockState(IMPLOSION_COMPRESSOR.getFirstTier()).getDescriptionId())
                .build()
        );
        INDUSTRIAL_GRINDER.setStructurePattern(b -> b
                .of("ccc ", "ccc ", "ccc ").of("CCC ", "CWCM", "CCC ").of(0)
                .at("M", INDUSTRIAL_GRINDER, INDUSTRIAL_GRINDER.getFirstTier(), Direction.SOUTH).at("C", REINFORCED_MACHINE_CASING.defaultBlockState()).at("c", STANDARD_MACHINE_CASING.defaultBlockState()).at("W", Blocks.WATER.defaultBlockState())
                .description(INDUSTRIAL_GRINDER.getBlockState(INDUSTRIAL_GRINDER.getFirstTier()).getDescriptionId())
                .build()
        );
        INDUSTRIAL_SAWMILL.setStructurePattern(b -> b
                .of("ccc", "cCc", "ccc").of("   ", " M ", "   ")
                .at("M", INDUSTRIAL_SAWMILL, INDUSTRIAL_SAWMILL.getFirstTier(), Direction.SOUTH).at("C", REINFORCED_MACHINE_CASING.defaultBlockState()).at("c", STANDARD_MACHINE_CASING.defaultBlockState())
                .description(INDUSTRIAL_SAWMILL.getBlockState(INDUSTRIAL_SAWMILL.getFirstTier()).getDescriptionId())
                .build()
        );
        DISTILLATION_TOWER.setStructurePattern(b -> b
                .of("CCC ", "CCCM", "CCC ").of("ccc ", "c c ", "ccc ").of("CCC ", "C C ", "CCC ").of(1).of("CCC ", "CCC ", "CCC ")
                .at("M", DISTILLATION_TOWER, DISTILLATION_TOWER.getFirstTier(), Direction.SOUTH).at("C", STANDARD_MACHINE_CASING.defaultBlockState()).at("c", ADVANCED_MACHINE_CASING.defaultBlockState())
                .description(DISTILLATION_TOWER.getBlockState(DISTILLATION_TOWER.getFirstTier()).getDescriptionId())
                .build()
        );
        BiFunction<Machine<?>, Block, PatternBuilder> builder2 = (m, b) -> new PatternBuilder().of("CCCC", "CCCC", "CCCC").of("ChhC", "EAAM", "CHHC").of(0)
                .at("M", m, m.getFirstTier(), Direction.SOUTH).at("C", b.defaultBlockState()).at("E", HATCH_DYNAMO, HATCH_DYNAMO.getFirstTier(), Direction.SOUTH);

        LARGE_STEAM_TURBINE.setStructurePattern(
                builder2.apply(LARGE_STEAM_TURBINE, STANDARD_MACHINE_CASING).at("H", STANDARD_MACHINE_CASING.defaultBlockState()).at("h", STANDARD_MACHINE_CASING.defaultBlockState()).description(STANDARD_MACHINE_CASING.getDescriptionId()).build(),
                builder2.apply(LARGE_STEAM_TURBINE, STANDARD_MACHINE_CASING).at("H", HATCH_FLUID_I, LV, Direction.WEST).at("h", HATCH_FLUID_I, LV, Direction.EAST).description(HATCH_FLUID_I.getBlockState(LV).getDescriptionId()).build(),
                builder2.apply(LARGE_STEAM_TURBINE, STANDARD_MACHINE_CASING).at("H", HATCH_FLUID_O, LV, Direction.WEST).at("h", HATCH_FLUID_O, LV, Direction.EAST).description(HATCH_FLUID_O.getBlockState(LV).getDescriptionId()).build(),
                builder2.apply(LARGE_STEAM_TURBINE, STANDARD_MACHINE_CASING).at("H", HATCH_MUFFLER, LV, Direction.WEST).at("h", HATCH_MUFFLER, LV, Direction.EAST).description(HATCH_MUFFLER.getBlockState(LV).getDescriptionId()).build()
        );
        builder = new PatternBuilder().of("CCC", "CHC", "CCC").of("CHC", "HAM", "CHC").of(0).at("M", THERMAL_BOILER, THERMAL_BOILER.getFirstTier(), Direction.SOUTH).at("C", REINFORCED_MACHINE_CASING.defaultBlockState());
        THERMAL_BOILER.setStructurePattern(
                builder.at("H", REINFORCED_MACHINE_CASING.defaultBlockState()).description(REINFORCED_MACHINE_CASING.getDescriptionId()).build(),
                builder.at("H", HATCH_FLUID_I, LV, Direction.EAST).description(HATCH_FLUID_I.getBlockState(LV).getDescriptionId()).build(),
                builder.at("H", HATCH_FLUID_O, LV, Direction.EAST).description(HATCH_FLUID_O.getBlockState(LV).getDescriptionId()).build(),
                builder.at("H", HATCH_ITEM_O, LV, Direction.EAST).description(HATCH_ITEM_O.getBlockState(LV).getDescriptionId()).build()
        );
        LARGE_GAS_TURBINE.setStructurePattern(
                builder2.apply(LARGE_GAS_TURBINE, REINFORCED_MACHINE_CASING).at("H", REINFORCED_MACHINE_CASING.defaultBlockState()).at("h", REINFORCED_MACHINE_CASING.defaultBlockState()).description(REINFORCED_MACHINE_CASING.getDescriptionId()).build(),
                builder2.apply(LARGE_GAS_TURBINE, REINFORCED_MACHINE_CASING).at("H", HATCH_FLUID_I, LV, Direction.WEST).at("h", HATCH_FLUID_I, LV, Direction.EAST).description(HATCH_FLUID_I.getBlockState(LV).getDescriptionId()).build(),
                builder2.apply(LARGE_GAS_TURBINE, REINFORCED_MACHINE_CASING).at("H", HATCH_FLUID_O, LV, Direction.WEST).at("h", HATCH_FLUID_O, LV, Direction.EAST).description(HATCH_FLUID_O.getBlockState(LV).getDescriptionId()).build(),
                builder2.apply(LARGE_GAS_TURBINE, REINFORCED_MACHINE_CASING).at("H", HATCH_MUFFLER, LV, Direction.WEST).at("h", HATCH_MUFFLER, LV, Direction.EAST).description(HATCH_MUFFLER.getBlockState(LV).getDescriptionId()).build()
        );
        builder = new PatternBuilder().of(
                "               ",
                "      BOB      ",
                "    OO   OO    ",
                "   O       O   ",
                "  O         O  ",
                "  O         O  ",
                " B           B ",
                " O           O ",
                " B           B ",
                "  O         O  ",
                "  O         O  ",
                "   O       O   ",
                "    OO   OO    ",
                "      BOB      ",
                "               "
        ).of(
                "      HOH      ",
                "    OOCCCOO    ",
                "   ECCHOHCCE   ",
                "  ECEO   OECE  ",
                " OCE       ECO ",
                " OCO       OCO ",
                "HCH         HCH",
                "OCM         OCO",
                "HCH         HCH",
                " OCO       OCO ",
                " OCE       ECO ",
                "  ECEO   OECE  ",
                "   ECCHOHCCE   ",
                "    OOCCCOO    ",
                "      HOH      "
        ).of(0).at("O", ADVANCED_MACHINE_CASING.defaultBlockState()).at("C", FUSION_COIL.defaultBlockState()).at("M", FUSION_REACTOR, FUSION_REACTOR.getFirstTier(), Direction.SOUTH).at("E", FUSION_ENERGY_INJECTOR, FUSION_ENERGY_INJECTOR.getFirstTier(), Direction.SOUTH);
        FUSION_REACTOR.setStructurePattern(
                builder.at("B", FUSION_ITEM_INJECTOR, FUSION_ITEM_INJECTOR.getFirstTier(), Direction.SOUTH).at("H", FUSION_ITEM_EXTRACTOR, FUSION_ITEM_EXTRACTOR.getFirstTier(), Direction.SOUTH).description(FUSION_REACTOR.getDisplayName(FUSION_REACTOR.getFirstTier()).getString() + " Item").build(),
                builder.at("B", FUSION_FLUID_INJECTOR, FUSION_FLUID_INJECTOR.getFirstTier(), Direction.SOUTH).at("H", FUSION_FLUID_EXTRACTOR, FUSION_FLUID_EXTRACTOR.getFirstTier(), Direction.SOUTH).description(FUSION_REACTOR.getDisplayName(FUSION_REACTOR.getFirstTier()).getString() + " Fluid").build()
        );
    }

    public static void init() {
        COKE_OVEN.setStructure(b -> b
            .of("ccc", "ccc", "ccc").of("CCC", "CAM", "CCC").of("CCC", "CCC", "CCC")
            .at("C", BRICK).at("M", COKE_OVEN).at("c", BRICK.cover(Direction.DOWN, Data.COVEROUTPUT))
            .build().offset(2, -1)
        );
        PYROLYSIS_OVEN.setStructure(b -> b
                .of("CCC", "CCM", "CCC").of("CCC", "CLC", "CCC").of("CCC", "CCC", "CCC")
                .at("M", PYROLYSIS_OVEN).at("C", CASING).at("L", AIR_OR_LAVA)
                .build().offset(2, 0)
        );
        PRIMITIVE_BLAST_FURNACE.setStructure(b -> b
            .of("CCC", "CCC", "CCC").of("CCC", "CBM", "CCC").of("CCC", "CBC", "CCC").of(2)
            .at("C", BRICK).at("B", AIR_OR_LAVA).at("M", PRIMITIVE_BLAST_FURNACE)
            .build().offset(2, -1)
        );
        BLAST_FURNACE.setStructure(b -> b
            .of("CCC ", "CCCM", "CCC ").of("CCC ", "CLC ", "CCC ").of(1).of("CCC ", "CCC ", "CCC ")
            .at("M", BLAST_FURNACE).at("C", STANDARD_MACHINE_CASING, REINFORCED_MACHINE_CASING, ADVANCED_MACHINE_CASING).at("L", AIR_OR_LAVA)
            .build().offset(3, 0)
        );
        VACUUM_FREEZER.setStructure(b -> b
            .of("CCC", "CcC", "CCC").of("CcC", "cAc", "CcC").of(0).of("   ", " M ", "   ")
            .at("M", VACUUM_FREEZER).at("C", REINFORCED_MACHINE_CASING).at("c", ADVANCED_MACHINE_CASING)
            .build().offset(1, -3).min(20, REINFORCED_MACHINE_CASING).min(6, ADVANCED_MACHINE_CASING)
        );
        IMPLOSION_COMPRESSOR.setStructure(b -> b
            .of("cCc", "CCC", "cCc").of("CCC", "CAC", "CCC").of(0).of("   ", " M ", "   ")
            .at("M", IMPLOSION_COMPRESSOR).at("C", REINFORCED_MACHINE_CASING).at("c", STANDARD_MACHINE_CASING)
            .build().offset(1, -3).min(18, REINFORCED_MACHINE_CASING).min(8, STANDARD_MACHINE_CASING)
        );
        INDUSTRIAL_GRINDER.setStructure(b -> b
                .of("ccc ", "ccc ", "ccc ").of("CCC ", "CWCM", "CCC ").of(0)
                .at("M", INDUSTRIAL_GRINDER).at("C", REINFORCED_MACHINE_CASING).at("c", STANDARD_MACHINE_CASING).at("W", WATER)
                .build().offset(3, -1)
        );
        INDUSTRIAL_SAWMILL.setStructure(b -> b
                .of("ccc", "cCc", "ccc").of("   ", " M ", "   ")
                .at("M", INDUSTRIAL_SAWMILL).at("C", REINFORCED_MACHINE_CASING).at("c", STANDARD_MACHINE_CASING)
                .build().offset(1, -1)
        );
        DISTILLATION_TOWER.setStructure(b -> b
                .of("CCC ", "CCCM", "CCC ").of("ccc ", "c c ", "ccc ").of("CCC ", "C C ", "CCC ").of(1).of("CCC ", "CCC ", "CCC ")
                .at("M", DISTILLATION_TOWER).at("C", STANDARD_MACHINE_CASING).at("c", ADVANCED_MACHINE_CASING)
                .build().offset(3, 0)
        );
        LARGE_STEAM_TURBINE.setStructure(b -> b
            .of("CCCC", "CCCC", "CCCC").of("CHHC", "EAAM", "CHHC").of(0)
            .at("M", LARGE_STEAM_TURBINE).at("C", STANDARD_MACHINE_CASING).at("H", STANDARD_MACHINE_CASING, HATCH_FLUID_I, HATCH_FLUID_O, HATCH_MUFFLER).at("E", HATCH_DYNAMO)
            .build().offset(3, -1).min(28, STANDARD_MACHINE_CASING).min(1, HATCH_FLUID_I, HATCH_MUFFLER)
        );
        THERMAL_BOILER.setStructure(b -> b
                .of("CCC", "CHC", "CCC").of("CHC", "HAM", "CHC").of(0)
                .at("M", THERMAL_BOILER).at("C", REINFORCED_MACHINE_CASING).at("H", REINFORCED_MACHINE_CASING, HATCH_FLUID_I, HATCH_FLUID_O, HATCH_ITEM_O)
                .build().offset(2, -1).min(2, HATCH_FLUID_I).min(1, HATCH_FLUID_O).min(20, REINFORCED_MACHINE_CASING));
        LARGE_GAS_TURBINE.setStructure(b -> b
                .of("CCCC", "CCCC", "CCCC").of("CHHC", "EAAM", "CHHC").of(0)
                .at("M", LARGE_GAS_TURBINE).at("C", REINFORCED_MACHINE_CASING).at("H", STANDARD_MACHINE_CASING, HATCH_FLUID_I, HATCH_FLUID_O, HATCH_MUFFLER).at("E", HATCH_DYNAMO)
                .build().offset(3, -1).min(28, STANDARD_MACHINE_CASING).min(1, HATCH_FLUID_I, HATCH_MUFFLER)
        );
        FUSION_REACTOR.setStructure(b -> b
            .of(
                "               ",
                "      BOB      ",
                "    OO   OO    ",
                "   O       O   ",
                "  O         O  ",
                "  O         O  ",
                " B           B ",
                " O           O ",
                " B           B ",
                "  O         O  ",
                "  O         O  ",
                "   O       O   ",
                "    OO   OO    ",
                "      BOB      ",
                "               "
            ).of(
                "      HOH      ",
                "    OOCCCOO    ",
                "   ECCHOHCCE   ",
                "  ECEO   OECE  ",
                " OCE       ECO ",
                " OCO       OCO ",
                "HCH         HCH",
                "OCM         OCO",
                "HCH         HCH",
                " OCO       OCO ",
                " OCE       ECO ",
                "  ECEO   OECE  ",
                "   ECCHOHCCE   ",
                "    OOCCCOO    ",
                "      HOH      "
            ).of(0)
            .at("O", ADVANCED_MACHINE_CASING).at("C", FUSION_COIL).at("M", FUSION_REACTOR).at("B", ADVANCED_MACHINE_CASING, FUSION_ITEM_INJECTOR, FUSION_FLUID_INJECTOR).at("H", ADVANCED_MACHINE_CASING, FUSION_ITEM_EXTRACTOR, FUSION_FLUID_EXTRACTOR).at("E", ADVANCED_MACHINE_CASING, FUSION_ENERGY_INJECTOR)
            .build().offset(2, -1).combined("fusion_injectors",2, FUSION_ITEM_INJECTOR, FUSION_FLUID_INJECTOR).combined("fusion_extractors",1, FUSION_ITEM_EXTRACTOR, FUSION_FLUID_EXTRACTOR).min(4, FUSION_ENERGY_INJECTOR));
    }
}
