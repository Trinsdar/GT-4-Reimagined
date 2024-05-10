package trinsdar.gt4r.data;


import io.github.gregtechintergalactical.gtcore.data.GTCoreBlocks;
import io.github.gregtechintergalactical.gtcore.data.GTCoreMaterials;
import io.github.gregtechintergalactical.gtcore.machine.DrumMachine;
import io.github.gregtechintergalactical.gtcore.machine.LockerMachine;
import io.github.gregtechintergalactical.gtcore.machine.MaterialMachine;
import io.github.gregtechintergalactical.gtcore.machine.WorkbenchMachine;
import muramasa.antimatter.blockentity.single.BlockEntityBatteryBuffer;
import muramasa.antimatter.blockentity.single.BlockEntityTransformer;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.machine.types.BasicMachine;
import muramasa.antimatter.machine.types.BasicMultiMachine;
import muramasa.antimatter.machine.types.GeneratorMachine;
import muramasa.antimatter.machine.types.HatchMachine;
import muramasa.antimatter.machine.types.MultiMachine;
import muramasa.antimatter.machine.types.TankMachine;
import muramasa.antimatter.blockentity.single.BlockEntityDigitalTransformer;
import muramasa.antimatter.util.Utils;
import net.minecraft.ChatFormatting;
import net.minecraft.sounds.SoundEvents;
import trinsdar.gt4r.GT4RRef;
import trinsdar.gt4r.block.BlockBatBox;
import trinsdar.gt4r.block.BlockRedstoneMachine;
import trinsdar.gt4r.machine.*;
import trinsdar.gt4r.blockentity.multi.*;
import trinsdar.gt4r.blockentity.multi.BlockEntityDistillationTower;
import trinsdar.gt4r.blockentity.single.*;
import trinsdar.gt4r.blockentity.single.BlockEntityQuantumChest;

import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.cover.ICover.emptyFactory;
import static muramasa.antimatter.machine.MachineFlag.*;
import static muramasa.antimatter.machine.Tier.*;
import static trinsdar.gt4r.data.GT4RData.COVER_DYNAMO_OLD;
import static trinsdar.gt4r.data.GT4RData.COVER_FUSION_INPUT;
import static trinsdar.gt4r.data.GT4RData.COVER_FUSION_OUTPUT;
import static trinsdar.gt4r.data.GT4RData.COVER_STEAM_VENT;
import static trinsdar.gt4r.data.RecipeMaps.*;

public class Machines {

    public static UpgradeableMachine ALLOY_SMELTER = new UpgradeableMachine(GT4RRef.ID, "alloy_smelter").setMap(ALLOY_SMELTING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine ASSEMBLER = new UpgradeableMachine(GT4RRef.ID, "assembler").setMap(ASSEMBLING).setTiers(LV).addFlags(GUI, ITEM).custom();
    public static UpgradeableMachine BENDER = new UpgradeableMachine(GT4RRef.ID, "plate_bender").setMap(BENDING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine CANNER = new UpgradeableMachine(GT4RRef.ID, "canner").setMap(CANNING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine COMPRESSOR = new UpgradeableMachine(GT4RRef.ID, "compressor").setMap(COMPRESSING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine CUTTER = new UpgradeableMachine(GT4RRef.ID, "cutter").setMap(CUTTING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine FURNACE = new UpgradeableMachine(GT4RRef.ID, "furnace").setMap(SMELTING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine EXTRACTOR = new UpgradeableMachine(GT4RRef.ID, "extractor").setMap(EXTRACTING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine EXTRUDER = new UpgradeableMachine(GT4RRef.ID, "extruder").setTiers(MV).setMap(EXTRUDING).addFlags(GUI, ITEM).custom();
    public static UpgradeableMachine LATHE = new UpgradeableMachine(GT4RRef.ID, "lathe").setMap(LATHING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine MACERATOR = new UpgradeableMachine(GT4RRef.ID, "macerator").setMap(MACERATING).addFlags(GUI, ITEM).setTiers(LV, MV).custom().overlayTexture(Textures.TIER_SPECIFIC_OVERLAY_HANDLER).setTierSpecificLang();
    public static UpgradeableMachine RECYCLER = new UpgradeableMachine(GT4RRef.ID, "recycler").setMap(RECYCLING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine SCANNER = new UpgradeableMachine(GT4RRef.ID, "scanner").setTiers(HV).setMap(SCANNING).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine WIRE_MILL = new UpgradeableMachine(GT4RRef.ID, "wire_mill").setMap(WIRE_MILLING).setTiers(LV).addFlags(GUI, ITEM).custom();
    public static UpgradeableMachine CENTRIFUGE = new UpgradeableMachine(GT4RRef.ID, "centrifuge").setMap(CENTRIFUGING).setTiers(LV).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine ELECTROLYZER = new UpgradeableMachine(GT4RRef.ID, "electrolyzer").setMap(ELECTROLYZING).addFlags(GUI, ITEM, FLUID).setTiers(LV, MV).setTierSpecificLang();
    public static UpgradeableMachine CHEMICAL_REACTOR = new UpgradeableMachine(GT4RRef.ID, "chemical_reactor").setTiers(MV).setMap(CHEMICAL_REACTING).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine FLUID_CANNER = new UpgradeableMachine(GT4RRef.ID, "fluid_canner").setMap(FLUID_CANNING).setTiers(LV).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine DISASSEMBLER = new UpgradeableMachine(GT4RRef.ID, "disassembler").setMap(DISASSEMBLING).setTiers(LV).addFlags(GUI, ITEM).custom();
    public static UpgradeableMachine MASS_FABRICATOR = new UpgradeableMachine(GT4RRef.ID, "mass_fabricator").setTiers(EV).setMap(MASS_FABRICATING).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine REPLICATOR = new UpgradeableMachine(GT4RRef.ID, "replicator").setTiers(EV).setMap(REPLICATING).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine FORGE_HAMMER = new UpgradeableMachine(GT4RRef.ID, "forge_hammer").setMap(HAMMERING).setTiers(LV).addFlags(GUI, ITEM).setTile(BlockEntityForgeHammer::new);
    public static UpgradeableMachine ORE_WASHER = new UpgradeableMachine(GT4RRef.ID, "ore_washer").setMap(ORE_WASHING).setTiers(LV).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine THERMAL_CENTRIFUGE = new UpgradeableMachine(GT4RRef.ID, "thermal_centrifuge").setTiers(MV).setMap(THERMAL_CENTRIFUGING).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine FLUID_PRESS = new UpgradeableMachine(GT4RRef.ID, "fluid_press").setMap(RecipeMaps.FLUID_PRESS).setTiers(LV).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine FLUID_SOLIDIFIER = new UpgradeableMachine(GT4RRef.ID, "fluid_solidifier").setMap(FLUID_SOLIDIFYING).setTiers(LV).addFlags(GUI, ITEM, FLUID);
    public static BasicMachine PUMP = new BasicMachine(GT4RRef.ID, "pump").addFlags(GUI, ITEM, FLUID).setTiers(LV).setTile(BlockEntityPump::new).baseTexture(Textures.BASE_HANDLER);
    public static UpgradeableMachine SIFTER = new UpgradeableMachine(GT4RRef.ID, "sifter").setMap(SIFTING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine SMELTER = new UpgradeableMachine(GT4RRef.ID, "smelter").setTiers(MV).setMap(RecipeMaps.SMELTER).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine BATH = new UpgradeableMachine(GT4RRef.ID, "bath").setMap(BATHING).setTiers(LV).addFlags(GUI, ITEM);
    public static UpgradeableMachine DISTILLERY = new UpgradeableMachine(GT4RRef.ID, "distillery").setMap(BASIC_DISTILLING).setTiers(LV).addFlags(GUI, ITEM, FLUID);
    public static UpgradeableMachine FERMENTER = new UpgradeableMachine(GT4RRef.ID, "fermenter").setMap(FERMENTING).setTiers(LV).addFlags(GUI, ITEM, FLUID);
    public static NonSolidMachine DUSTBIN = new NonSolidMachine(GT4RRef.ID, "dustbin").setMap(RecipeMaps.DUSTBIN).addFlags(GUI, ITEM).setTiers(LV).custom().baseTexture(Textures.DUSTBIN_HANDLER).covers(emptyFactory).frontCovers().setTile(BlockEntityDustBin::new);

    public static SteamMachine SOLID_FUEL_BOILER = new SteamMachine(GT4RRef.ID, "solid_fuel_boiler").setMap(SOLID_FUEL_BOILERS).setTiers(BRONZE, STEEL).addFlags(GUI, STEAM, ITEM, FLUID, CELL).baseTexture(Textures.BOILER_HANDLER).setTile(BlockEntityCoalBoiler::new).noCovers();
    public static SteamMachine STEAM_FURNACE = new SteamMachine(GT4RRef.ID, "steam_furnace").setTiers(BRONZE, STEEL).addFlags(GUI, STEAM, ITEM, FLUID).setMap(RecipeMaps.STEAM_FURNACE).baseTexture(Textures.BRICKED_HANDLER).covers(COVER_STEAM_VENT);
    public static SteamMachine STEAM_MACERATOR = new SteamMachine(GT4RRef.ID, "steam_macerator").setTiers(BRONZE, STEEL).addFlags(GUI, STEAM, ITEM, FLUID).setMap(RecipeMaps.STEAM_MACERATOR).covers(COVER_STEAM_VENT);
    public static SteamMachine STEAM_EXTRACTOR = new SteamMachine(GT4RRef.ID, "steam_extractor").setTiers(BRONZE, STEEL).addFlags(GUI, STEAM, ITEM, FLUID).setMap(RecipeMaps.STEAM_EXTRACTOR).covers(COVER_STEAM_VENT);
    public static SteamMachine STEAM_FORGE_HAMMER = new SteamMachine(GT4RRef.ID, "steam_forge_hammer").setTiers(BRONZE, STEEL).addFlags(GUI, STEAM, ITEM, FLUID).setMap(RecipeMaps.STEAM_FORGE_HAMMER).covers(COVER_STEAM_VENT);
    public static SteamMachine STEAM_COMPRESSOR = new SteamMachine(GT4RRef.ID, "steam_compressor").setTiers(BRONZE, STEEL).addFlags(GUI, STEAM, ITEM, FLUID).setMap(RecipeMaps.STEAM_COMPRESSOR).covers(COVER_STEAM_VENT);
    public static SteamMachine STEAM_ALLOY_SMELTER = new SteamMachine(GT4RRef.ID, "steam_alloy_smelter").setTiers(BRONZE, STEEL).addFlags(GUI, STEAM, ITEM, FLUID).setMap(RecipeMaps.STEAM_ALLOY_SMELTER).baseTexture(Textures.BRICKED_HANDLER).covers(COVER_STEAM_VENT);
    public static SteamMachine STEAM_CUTTER = new SteamMachine(GT4RRef.ID, "steam_cutter").setTiers(BRONZE, STEEL).addFlags(GUI, STEAM, ITEM, FLUID).setMap(RecipeMaps.STEAM_CUTTER).covers(COVER_STEAM_VENT);
    public static SteamMachine STEAM_SIFTER = new SteamMachine(GT4RRef.ID, "steam_sifter").setTiers(BRONZE, STEEL).addFlags(GUI, STEAM, ITEM, FLUID).setMap(RecipeMaps.STEAM_SIFTER).covers(COVER_STEAM_VENT);

    public static BasicMachine TELEPORTER = new BasicMachine(GT4RRef.ID, "teleporter").baseTexture(Textures.BASE_HANDLER).setTiers(HV, LUV).setTile(BlockEntityTeleporter::new).overlayTexture(Textures.TIER_SPECIFIC_OVERLAY_HANDLER);
    public static BasicMachine COMPUTER_CUBE = new BasicMachine(GT4RRef.ID, "computer_cube").baseTexture(Textures.BASE_HANDLER).setTiers(LV).overlayTexture(Textures.SIMPLE_SIDED).noCovers();
    public static BasicMachine ELECTRIC_ITEM_FILTER = new BasicMachine(GT4RRef.ID, "electric_item_filter").baseTexture(Textures.BASE_HANDLER).setTiers(LV).addFlags(GUI, ITEM).setTile(BlockEntityItemFilter::new).noCovers().allowFrontIO().setVerticalFacingAllowed(true).overlayTexture(Textures.LEFT_RIGHT_HANDLER);
    public static BasicMachine ELECTRIC_TYPE_FILTER = new BasicMachine(GT4RRef.ID, "electric_type_filter").baseTexture(Textures.BASE_HANDLER).setTiers(LV).addFlags(GUI, ITEM).setTile(BlockEntityTypeFilter::new).noCovers().allowFrontIO().setVerticalFacingAllowed(true).overlayTexture(Textures.LEFT_RIGHT_HANDLER);
    public static BasicMachine ELECTRIC_ITEM_TRANSLOCATOR = new BasicMachine(GT4RRef.ID, "electric_item_translocator").baseTexture(Textures.BASE_HANDLER).setTiers(LV).addFlags(GUI, ITEM).setTile(BlockEntityTranslocator.BlockEntityItemTranslocator::new).noCovers().allowFrontIO().setVerticalFacingAllowed(true).overlayTexture(Textures.LEFT_RIGHT_HANDLER);
    public static BasicMachine ELECTRIC_FLUID_TRANSLOCATOR = new BasicMachine(GT4RRef.ID, "electric_fluid_translocator").baseTexture(Textures.BASE_HANDLER).setTiers(LV).addFlags(GUI, ITEM, FLUID).setTile(BlockEntityTranslocator.BlockEntityFluidTranslocator::new).noCovers().allowFrontIO().setVerticalFacingAllowed(true).overlayTexture(Textures.LEFT_RIGHT_HANDLER);

    public static BasicMachine PLAYER_DETECTOR = new BasicMachine(GT4RRef.ID, "player_detector").baseTexture(Textures.BASE_HANDLER).setTiers(LV).setTile(BlockEntityPlayerDetector::new).setBlock(BlockRedstoneMachine::new).setItemBlockClass(() -> BlockRedstoneMachine.class).frontCovers().noCovers().allowFrontIO().overlayTexture(Textures.SIMPLE_ACTIVE_SIDED);

    public static BasicMultiMachine<?> COKE_OVEN = new BasicMultiMachine<>(GT4RRef.ID, "coke_oven").setMap(COKING).setTiers(NONE).addFlags(GUI, ITEM, FLUID).setTile(BlockEntityCokeOven::new);
    public static BasicMultiMachine<?> PRIMITIVE_BLAST_FURNACE = new BasicMultiMachine<>(GT4RRef.ID, "primitive_blast_furnace").setMap(BASIC_BLASTING).setTiers(NONE).addFlags(GUI, ITEM).setTile(BlockEntityPrimitiveBlastFurnace::new);
    public static MultiMachine CHARCOAL_PIT = new MultiMachine(GT4RRef.ID, "charcoal_pit").setTiers(LV).setTile(BlockEntityCharcoalPit::new);
    public static BasicMultiMachine<?> BLAST_FURNACE = new UpgradeableBasicMultiMachine(GT4RRef.ID, "industrial_blast_furnace").setMap(BLASTING).setTiers(MV).addFlags(GUI, ITEM, EU).setTile(BlockEntityIndustrialBlastFurnace::new);
    public static BasicMultiMachine<?> IMPLOSION_COMPRESSOR = new UpgradeableBasicMultiMachine(GT4RRef.ID, "implosion_compressor").setMap(IMPLOSION_COMPRESSING).setTiers(LV).addFlags(GUI, ITEM, EU);
    public static BasicMultiMachine<?> INDUSTRIAL_GRINDER = new UpgradeableBasicMultiMachine(GT4RRef.ID, "industrial_grinder").setMap(INDUSTRIAL_GRINDING).setTiers(MV).addFlags(GUI, ITEM, EU, FLUID);
    public static BasicMultiMachine<?> INDUSTRIAL_SAWMILL = new UpgradeableBasicMultiMachine(GT4RRef.ID, "industrial_sawmill").setMap(INDUSTRIAL_SAWMILLING).setTiers(MV).addFlags(GUI, ITEM, EU, FLUID);
    public static BasicMultiMachine<?> DISTILLATION_TOWER = new UpgradeableBasicMultiMachine(GT4RRef.ID, "distillation_tower").setMap(DISTILLING).setTiers(MV).addFlags(GUI, ITEM, EU, FLUID);
    public static BasicMultiMachine<?> VACUUM_FREEZER = new UpgradeableBasicMultiMachine(GT4RRef.ID, "vacuum_freezer").setMap(VACUUM_FREEZING).setTiers(LV).addFlags(GUI, ITEM, FLUID, EU);
    public static BasicMultiMachine<?> PYROLYSIS_OVEN = new UpgradeableBasicMultiMachine(GT4RRef.ID, "pyrolysis_oven").setTiers(LV).addFlags(GUI, ITEM, FLUID, EU).setTile(BlockEntityPyrolysisOven::new);
    public static MultiMachine THERMAL_BOILER = new MultiMachine(GT4RRef.ID, "thermal_boiler").setMap(THERMAL_BOILER_FUELS).setTiers(LV).addFlags(GUI, ITEM, FLUID).setTile(BlockEntityThermalBoiler::new);
    public static MultiMachine LARGE_STEAM_TURBINE = new MultiMachine(GT4RRef.ID, "large_steam_turbine").setMap(LARGE_STEAM_FUELS).setTiers(EV).addFlags(GUI, FLUID, ITEM, EU, GENERATOR).setTile(BlockEntityLargeTurbine::new).custom(Textures.TURBINE);
    public static MultiMachine LARGE_GAS_TURBINE = new MultiMachine(GT4RRef.ID, "large_gas_turbine").setMap(LARGE_GAS_FUELS).setTiers(IV).addFlags(GUI, FLUID, ITEM, EU, GENERATOR).setTile(BlockEntityLargeTurbine::new).custom(Textures.TURBINE);
    public static MultiMachine LARGE_HEAT_EXCHANGER = new MultiMachine(GT4RRef.ID, "large_heat_exchanger").setTiers(EV).addFlags(GUI, FLUID, EU).setTile(BlockEntityLargeHeatExchanger::new);
    public static MultiMachine FUSION_REACTOR = new MultiMachine(GT4RRef.ID, "fusion_control_computer").setMap(FUSION).setTiers(IV).addFlags(GUI, FLUID, EU).setTile(BlockEntityFusionReactor::new);

    public static HatchMachine HATCH_ITEM_I = new HatchMachine(GT4RRef.ID, "item_input_hatch", COVERINPUT).baseTexture(Textures.BASE_HANDLER).addFlags(GUI, ITEM).setTiers(LV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine HATCH_ITEM_O = new HatchMachine(GT4RRef.ID, "item_output_hatch", COVEROUTPUT).baseTexture(Textures.BASE_HANDLER).addFlags(GUI, ITEM).setTiers(LV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine HATCH_FLUID_I = new HatchMachine(GT4RRef.ID, "fluid_input_hatch", COVERINPUT).baseTexture(Textures.BASE_HANDLER).addFlags(GUI, FLUID, CELL).setTiers(LV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine HATCH_FLUID_O = new HatchMachine(GT4RRef.ID, "fluid_output_hatch", COVEROUTPUT).baseTexture(Textures.BASE_HANDLER).addFlags(GUI, FLUID, CELL).setTiers(LV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine HATCH_MUFFLER = new HatchMachine(GT4RRef.ID, "muffler_hatch", COVERMUFFLER).baseTexture(Textures.BASE_HANDLER).addFlags(GUI, ITEM).setTiers(LV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine HATCH_DYNAMO = new HatchMachine(GT4RRef.ID, "dynamo_hatch", COVER_DYNAMO_OLD).baseTexture(Textures.BASE_HANDLER).addFlags(EU).setTiers(EV, IV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine FUSION_ITEM_INJECTOR = new HatchMachine(GT4RRef.ID, "fusion_item_injector", COVER_FUSION_INPUT).addFlags(GUI, ITEM).baseTexture(Textures.FUSION_IN).setTiers(LV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine FUSION_ITEM_EXTRACTOR = new HatchMachine(GT4RRef.ID, "fusion_item_extractor", COVER_FUSION_OUTPUT).addFlags(GUI, ITEM).baseTexture(Textures.FUSION_OUT).setTiers(LV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine FUSION_FLUID_INJECTOR = new HatchMachine(GT4RRef.ID, "fusion_fluid_injector", COVER_FUSION_INPUT).addFlags(GUI, FLUID, CELL).baseTexture(Textures.FUSION_IN).setTiers(LV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine FUSION_FLUID_EXTRACTOR = new HatchMachine(GT4RRef.ID, "fusion_fluid_extractor", COVER_FUSION_OUTPUT).addFlags(GUI, FLUID, CELL).baseTexture(Textures.FUSION_OUT).setTiers(LV).setVerticalFacingAllowed(false).allowFrontIO();
    public static HatchMachine FUSION_ENERGY_INJECTOR = new HatchMachine(GT4RRef.ID, "fusion_energy_injector", emptyFactory).addFlags(EU).baseTexture(Textures.FUSION_IN).setTiers(IV).setVerticalFacingAllowed(false).allowFrontIO();
    //public static HatchMachine FUSION_ENERGY_EXTRACTOR = new HatchMachine(Ref.ID, "fusion_energy_extractor", COVER_DYNAMO_OLD).addFlags(ENERGY).baseTexture(Textures.FUSION_OUT).setTiers(UV).setAllowVerticalFacing(false).allowFrontIO();

    public static TankMachine QUANTUM_TANK = new TankMachine(GT4RRef.ID, "quantum_tank").addFlags(GUI, CELL).setTiers(MAX).setTile(BlockEntityQuantumTank::new).frontCovers().allowFrontIO();
    public static TankMachine DIGITAL_TANK = new TankMachine(GT4RRef.ID, "digital_tank").addFlags(GUI, CELL, ITEM).setTiers(LV).setTile(BlockEntityDigitalTank::new).frontCovers().allowFrontIO();
    public static StorageMachine QUANTUM_CHEST = new StorageMachine(GT4RRef.ID, "quantum_chest").addFlags(GUI, ITEM).setTiers(MAX).setTile(BlockEntityQuantumChest::new);
    public static StorageMachine DIGITAL_CHEST = new StorageMachine(GT4RRef.ID, "digital_chest").addFlags(GUI, ITEM).setTiers(LV).setTile(BlockEntityDigitalChest::new);

    public static DrumMachine BRONZE_DRUM = GTCoreBlocks.createDrum(Materials.Bronze, 16000);
    public static DrumMachine INVAR_DRUM = GTCoreBlocks.createDrum(Materials.Invar, 32000);
    public static DrumMachine STEEL_DRUM = GTCoreBlocks.createDrum(Materials.Steel, 48000);
    public static DrumMachine STAINLESS_STEEL_DRUM = GTCoreBlocks.createDrum(Materials.StainlessSteel, 64000).acidProof();
    public static DrumMachine TUNGSTEN_DRUM = GTCoreBlocks.createDrum(Materials.Tungsten, 256000);
    public static DrumMachine TUNGSTENSTEEL_DRUM = GTCoreBlocks.createDrum(Materials.TungstenSteel, 256000);
    public static DrumMachine NETHERITE_DRUM = GTCoreBlocks.createDrum(AntimatterMaterials.Netherite, 128000).acidProof();

    public static MaterialMachine IRON_CABINET = GTCoreBlocks.createBarrel(AntimatterMaterials.Iron);
    public static MaterialMachine ALUMINIUM_CABINET = GTCoreBlocks.createBarrel(GTCoreMaterials.Aluminium);
    public static MaterialMachine WROUGHT_IRON_CABINET = GTCoreBlocks.createBarrel(GTCoreMaterials.WroughtIron);
    public static MaterialMachine BRASS_CABINET = GTCoreBlocks.createBarrel(GTCoreMaterials.Brass);

    public static MaterialMachine IRON_CHEST = GTCoreBlocks.createChest(AntimatterMaterials.Iron);
    public static MaterialMachine ALUMINIUM_CHEST = GTCoreBlocks.createChest(GTCoreMaterials.Aluminium);
    public static MaterialMachine WROUGHT_IRON_CHEST = GTCoreBlocks.createChest(GTCoreMaterials.WroughtIron);
    public static MaterialMachine BRASS_CHEST = GTCoreBlocks.createChest(GTCoreMaterials.Brass);

    public static WorkbenchMachine BRONZE_WORKBENCH = GTCoreBlocks.createWorkbench(Materials.Bronze, false);
    public static WorkbenchMachine IRON_WORKBENCH = GTCoreBlocks.createWorkbench(AntimatterMaterials.Iron, false);
    public static WorkbenchMachine ALUMINIUM_WORKBENCH = GTCoreBlocks.createWorkbench(Materials.Aluminium, false);
    public static WorkbenchMachine IRON_CHARGING_WORKBENCH = GTCoreBlocks.createWorkbench(AntimatterMaterials.Iron, true);
    public static WorkbenchMachine ALUMINIUM_CHARGING_WORKBENCH = GTCoreBlocks.createWorkbench(Materials.Aluminium, true);
    public static LockerMachine IRON_LOCKER = GTCoreBlocks.createLocker(AntimatterMaterials.Iron, false);
    public static LockerMachine ALUMINIUM_LOCKER = GTCoreBlocks.createLocker(Materials.Aluminium, false);
    public static LockerMachine IRON_CHARGING_LOCKER = GTCoreBlocks.createLocker(AntimatterMaterials.Iron, true);
    public static LockerMachine ALUMINIUM_CHARGING_LOCKER = GTCoreBlocks.createLocker(Materials.Aluminium, true);

    public static GeneratorMachine STEAM_TURBINE = new GeneratorMachine(GT4RRef.ID, "steam_turbine").baseTexture(Textures.BASE_HANDLER).frontCovers().allowFrontIO().setMap(STEAM_FUELS).setTiers(LV).addFlags(GUI, ITEM, FLUID, GENERATOR, CELL).covers(emptyFactory,emptyFactory,emptyFactory,emptyFactory,emptyFactory, COVER_DYNAMO_OLD).setVerticalFacingAllowed(false).setOutputCover(COVER_DYNAMO_OLD).setTile(BlockEntityCoveredGenerator::new);
    public static GeneratorMachine GAS_TURBINE = new GeneratorMachine(GT4RRef.ID, "gas_turbine").baseTexture(Textures.BASE_HANDLER).frontCovers().allowFrontIO().setMap(GAS_FUELS).setTiers(LV).addFlags(GUI, ITEM, FLUID, GENERATOR, CELL).covers(emptyFactory,emptyFactory,emptyFactory,emptyFactory,emptyFactory, COVER_DYNAMO_OLD).setVerticalFacingAllowed(false).setOutputCover(COVER_DYNAMO_OLD).setTile(BlockEntityCoveredGenerator::new);
    public static BasicMachine HEAT_EXCHANGER = new BasicMachine(GT4RRef.ID, "heat_exchanger").baseTexture(Textures.BASE_HANDLER).setMap(HOT_FUELS).setTiers(LV).addFlags(GUI, FLUID).overlayTexture(Textures.LEFT_RIGHT_HANDLER).covers(emptyFactory).setTile(BlockEntityHeatExchanger::new);
    public static GeneratorMachine DIESEL_GENERATOR = new GeneratorMachine(GT4RRef.ID, "diesel_generator").baseTexture(Textures.BASE_HANDLER).frontCovers().allowFrontIO().setMap(DIESEL_FUELS).setTiers(LV).addFlags(GUI, ITEM, FLUID, GENERATOR, CELL).covers(emptyFactory,emptyFactory,emptyFactory,emptyFactory,emptyFactory, COVER_DYNAMO_OLD).setVerticalFacingAllowed(false).setOutputCover(COVER_DYNAMO_OLD).setTile(BlockEntityCoveredGenerator::new);
    public static GeneratorMachine SEMIFLUID_GENERATOR = new GeneratorMachine(GT4RRef.ID, "semifluid_generator").baseTexture(Textures.BASE_HANDLER).frontCovers().allowFrontIO().setMap(SEMIFLUID_FUELS).setTiers(LV).addFlags(GUI, ITEM, FLUID, GENERATOR, CELL).covers(emptyFactory,emptyFactory,emptyFactory,emptyFactory,emptyFactory, COVER_DYNAMO_OLD).setVerticalFacingAllowed(false).setOutputCover(COVER_DYNAMO_OLD).setTile(BlockEntityCoveredGenerator::new);
    public static GeneratorMachine WINDMILL = new GeneratorMachine(GT4RRef.ID, "windmill").baseTexture(Textures.BASE_HANDLER).setTiers(ULV).covers(emptyFactory,emptyFactory,emptyFactory,emptyFactory,emptyFactory, COVER_DYNAMO_OLD).allowFrontIO().setVerticalFacingAllowed(false).setOutputCover(COVER_DYNAMO_OLD).setTile(BlockEntityCoveredGenerator::new);
    public static GeneratorMachine WATERMILL = new GeneratorMachine(GT4RRef.ID, "watermill").baseTexture(Textures.BASE_HANDLER).setTiers(ULV).covers(emptyFactory,emptyFactory,emptyFactory,emptyFactory,emptyFactory, COVER_DYNAMO_OLD).allowFrontIO().setVerticalFacingAllowed(false).setOutputCover(COVER_DYNAMO_OLD).setTile(BlockEntityCoveredGenerator::new).custom();

    public static TankMachine INFINITE_STEAM = new TankMachine(GT4RRef.ID, "infinite_steam").addFlags(FLUID, CELL, GUI).setTiers(LV).setTile(BlockEntityInfiniteFluid::new);
    public static UpgradeableMachine BATTERY_BUFFER_FOUR = new UpgradeableMachine(GT4RRef.ID, "4x_battery_buffer").setTiers(LV).noCovers().addFlags(GUI, EU, ITEM).setUpgrades(CustomTags.TRANSFORMER_UPGRADES).setTile(BlockEntityBatteryBox::new).setBlock(BlockBatBox::new).setItemBlockClass(() -> BlockBatBox.class).overlayTexture(Textures.TIER_SPECIFIC_OVERLAY_HANDLER).baseTexture(Textures.BATBOX_HANDLER).allowFrontIO().setVerticalFacingAllowed(true);
    public static UpgradeableMachine BATTERY_BUFFER_EIGHT = new UpgradeableMachine(GT4RRef.ID, "8x_battery_buffer").setTiers(LV).noCovers().addFlags(GUI, EU, ITEM).setUpgrades(CustomTags.TRANSFORMER_UPGRADES).setTile(BlockEntityBatteryBox::new).setBlock(BlockBatBox::new).setItemBlockClass(() -> BlockBatBox.class).overlayTexture(Textures.TIER_SPECIFIC_OVERLAY_HANDLER).baseTexture(Textures.BATBOX_HANDLER).allowFrontIO().setVerticalFacingAllowed(true);
    public static BasicMachine TRANSFORMER = new BasicMachine(GT4RRef.ID, "transformer").addFlags(EU).baseTexture(Textures.BATBOX_HANDLER).overlayTexture(Textures.TIER_SPECIFIC_OVERLAY_HANDLER).setTile((m, p, s) -> new BlockEntityTransformer<>(m, p, s, 1)).noCovers().setVerticalFacingAllowed(true).allowFrontIO().addTooltipInfo((machine, stack, world, tooltip, flag) -> {
        tooltip.remove(tooltip.size() - 1);
        tooltip.remove(tooltip.size() - 1);
        Tier upper = Tier.getTier(machine.getTier().getVoltage() * 4);
        tooltip.add(Utils.translatable("machine.transformer.voltage_info", Utils.literal(upper.getId().toUpperCase()), Utils.literal(machine.getTier().getId().toUpperCase())));
        tooltip.add(Utils.translatable("machine.voltage.in").append(": ").append(Utils.literal(upper.getVoltage() + " (" + upper.getId().toUpperCase() + ")")).withStyle(ChatFormatting.GREEN));
        tooltip.add(Utils.translatable("machine.voltage.out").append(": ").append(Utils.literal(machine.getTier().getVoltage() + " (" + machine.getTier().getId().toUpperCase() + ")")).withStyle(ChatFormatting.GREEN));
        tooltip.add(Utils.translatable("generic.amp").append(": ").append(Utils.literal(String.valueOf(4)).withStyle(ChatFormatting.YELLOW)));
        tooltip.add(Utils.translatable("machine.power.capacity").append(": ").append(Utils.literal(String.valueOf(512L + machine.getTier().getVoltage() * 8L))).withStyle(ChatFormatting.BLUE));
    });
    public static BasicMachine SUPERCONDENSATOR = new BasicMachine(GT4RRef.ID, "supercondensator").addFlags(EU).setTile((m, p, s) -> new BlockEntitySupercondensator(m, p, s, 1)).setTiers(LUV).noCovers().setVerticalFacingAllowed(true).allowFrontIO();
    public static BasicMachine TRANSFORMER_DIGITAL = new BasicMachine(GT4RRef.ID, "transformer_digital").addFlags(GUI, EU).setTiers(EV, IV).setTile(BlockEntityDigitalTransformer::new).noCovers().allowFrontIO();

    public static void init() {
        STEAM_TURBINE.setOutputCover(COVER_DYNAMO_OLD);
        GAS_TURBINE.setOutputCover(COVER_DYNAMO_OLD);
        DIESEL_GENERATOR.setOutputCover(COVER_DYNAMO_OLD);
        SEMIFLUID_GENERATOR.setOutputCover(COVER_DYNAMO_OLD);
        WINDMILL.setOutputCover(COVER_DYNAMO_OLD);
        WATERMILL.setOutputCover(COVER_DYNAMO_OLD);
        HEAT_EXCHANGER.removeFlags(EU);
        DUSTBIN.removeFlags(EU);
    }
}
