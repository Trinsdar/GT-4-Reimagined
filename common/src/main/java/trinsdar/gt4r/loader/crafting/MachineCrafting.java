package trinsdar.gt4r.loader.crafting;

import com.google.common.collect.ImmutableMap;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.machine.types.Machine;
import muramasa.antimatter.pipe.PipeSize;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import trinsdar.gt4r.Ref;
import muramasa.antimatter.data.ForgeCTags;
import trinsdar.gt4r.data.GT4RMaterialTags;

import java.util.function.Consumer;

import static com.google.common.collect.ImmutableMap.of;
import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.machine.Tier.*;
import static muramasa.antimatter.util.TagUtils.getForgelikeItemTag;
import static trinsdar.gt4r.data.CustomTags.*;
import static trinsdar.gt4r.data.GT4RData.*;
import static trinsdar.gt4r.data.Machines.*;
import static trinsdar.gt4r.data.Materials.*;
import static trinsdar.gt4r.loader.crafting.CraftingHelper.of2;

public class MachineCrafting {
    public static void loadRecipes(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider) {
        provider.addItemRecipe(output, Ref.ID, "mv_electrolyzer", "machines", "has_extractor", provider.hasSafeItem(EXTRACTOR.getItem(LV)),
                ELECTROLYZER.getItem(MV), of('C', CIRCUITS_ADVANCED, 'P', PLATES_STEELS, 'E', EXTRACTOR.getItem(LV), 'L', CopperCoil), "PEP", "CLC", "PEP");
        provider.addItemRecipe(output, Ref.ID, "mv_electrolyzer_upgrade", "machines", "has_lv_electrolyzer", provider.hasSafeItem(ELECTROLYZER.getItem(LV)),
                ELECTROLYZER.getItem(MV), of('C', CIRCUITS_ADVANCED, 'P', PLATES_STEELS, 'E', ELECTROLYZER.getItem(LV)), " P ", "CEC", " P ");
        provider.addItemRecipe(output, Ref.ID, "lv_electrolyzer", "machines", "has_extractor", provider.hasSafeItem(EXTRACTOR.getItem(LV)),
                ELECTROLYZER.getItem(LV), of('C', CIRCUITS_BASIC, 'P', PLATES_WROUGHT_ALUMINIUM, 'E', EXTRACTOR.getItem(LV), 'L', CopperCoil), "PEP", "CLC", "PEP");
        provider.addItemRecipe(output, Ref.ID, "industrial_grinder", "machines", "has_electrolyzer", provider.hasSafeItem(ELECTROLYZER.getItem(MV)),
                INDUSTRIAL_GRINDER.getItem(MV), of('E', ELECTROLYZER.getItem(MV),'C', CIRCUITS_ADVANCED, 'M', MACHINE_HULLS_ADVANCED, 'P', PUMP.getItem(LV), 'G', GRINDING_HEAD), "ECP", "GGG", "CMC");
        provider.addItemRecipe(output, Ref.ID, "industrial_blast_furnace", "machines", "has_cupronickel_coils", provider.hasSafeItem(CupronickelHeatingCoil),
                BLAST_FURNACE.getItem(MV), of('C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'H', CupronickelHeatingCoil, 'F', FURNACE.getItem(LV)), "CHC", "HMH", "FHF");
        provider.addItemRecipe(output, Ref.ID, "pyrolysis_oven", "machines", "has_pump_module", provider.hasSafeItem(PumpModule),
                PYROLYSIS_OVEN.getItem(LV), of('C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'p', PumpModule, 'P', PISTONS, 'F', FURNACE.getItem(LV)), "PCP", "CMC", "FpF");
        provider.addItemRecipe(output, Ref.ID, "implosion_compressor", "machines", "has_compressor", provider.hasSafeItem(COMPRESSOR.getItem(LV)),
                IMPLOSION_COMPRESSOR.getItem(LV), of('C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'c', COMPRESSOR.getItem(LV), 'A', AdvancedAlloy), "AMA", "CcC", "AMA");
        provider.addItemRecipe(output, Ref.ID, "industrial_sawmill", "machines", "has_pump", provider.hasSafeItem(PUMP.getItem(LV)),
                INDUSTRIAL_SAWMILL.getItem(MV), of('C', CIRCUITS_ADVANCED, 'M', MACHINE_HULLS_ADVANCED, 'P', PUMP.getItem(LV), 'S', DiamondSawBlade), "PCP", "SSS", "CMC");
        provider.addItemRecipe(output, Ref.ID, "vacuum_freezer", "machines", "has_pump", provider.hasSafeItem(PUMP.getItem(LV)),
                VACUUM_FREEZER.getItem(LV), of('C', CIRCUITS_BASIC, 'G', REINFORCED_GLASS, 'P', PUMP.getItem(LV), 'A', PLATE.getMaterialTag(Aluminium)), "APA", "CGC", "APA");
        provider.addItemRecipe(output, Ref.ID, "chemical_reactor", "machines", "has_extractor", provider.hasSafeItem(EXTRACTOR.getItem(LV)),
                CHEMICAL_REACTOR.getItem(MV), of('C', CIRCUITS_ADVANCED, 'P', PLATES_INVAR_ALUMINIUM, 'E', EXTRACTOR.getItem(LV), 'L', CopperCoil, 'c', COMPRESSOR.getItem(LV)), "PLP", "CcC", "PEP");
        provider.addItemRecipe(output, Ref.ID, "distillation_tower", "machines", "has_centrifuge", provider.hasSafeItem(CENTRIFUGE.getItem(LV)),
                DISTILLATION_TOWER.getItem(MV), of('C', CIRCUITS_MASTER, 'P', PUMP.getItem(LV), 'E', ELECTROLYZER.getItem(MV), 'c', CENTRIFUGE.getItem(LV), 'A', HIGHLY_ADVANCED_MACHINE_BLOCK), "cCc", "PAP", "ECE");
        provider.addItemRecipe(output, Ref.ID, "macerator_1", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                MACERATOR.getItem(LV), of('C', CIRCUITS_ADVANCED, 'P', PLATES_STEELS, 'M', MACHINE_HULLS_BASIC, 'D', DUST.getMaterialTag(Diamond)), "PDP", "DMD", "PCP");
        provider.addItemRecipe(output, Ref.ID, "macerator_2", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                MACERATOR.getItem(LV), of('C', CIRCUITS_BASIC, 'P', PLATES_STEELS, 'M', MACHINE_HULLS_BASIC, 'D', GRINDING_HEAD), "PDP", "CMC", "PCP");
        provider.addItemRecipe(output, Ref.ID,"extractor","machines", "has_piston", provider.hasSafeItem(PISTONS),
                EXTRACTOR.getItem(LV), of('C', CIRCUITS_BASIC, 'P', PISTONS, 'M', MACHINE_HULLS_BASIC, 'G', getForgelikeItemTag("glass")), "GMG", "PCP");
        provider.addItemRecipe(output, Ref.ID,"compressor","machines", "has_piston", provider.hasSafeItem(PISTONS),
                COMPRESSOR.getItem(LV), of('C', CIRCUITS_BASIC, 'P', PISTONS, 'M', MACHINE_HULLS_BASIC, 'S', getForgelikeItemTag("stone")), "S S", "PMP", "SCS");
        provider.addItemRecipe(output, Ref.ID,"forge_hammer","machines", "has_piston", provider.hasSafeItem(PISTONS),
                FORGE_HAMMER.getItem(LV), of('C', CIRCUITS_BASIC, 'P', PISTONS, 'M', MACHINE_HULLS_BASIC, 'A', Items.ANVIL), " P ", "CMC", " A ");
        provider.addItemRecipe(output, Ref.ID,"e_furnace","machines", "has_steam_furnace", provider.hasSafeItem(STEAM_FURNACE.getItem(STEEL)),
                FURNACE.getItem(LV), of('C', CIRCUITS_BASIC, 'S', STEAM_FURNACE.getItem(STEEL), 'R', DUST.getMaterialTag(Redstone)), " C ", "RSR");
        provider.addItemRecipe(output, Ref.ID,"wiremill","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                WIRE_MILL.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', MACHINE_HULLS_BASIC, 'D', GEM.getMaterialTag(Diamond), 'B', PLATE.getMaterialTag(Brass)), "BDB", "CMC", "BcB");
        provider.addItemRecipe(output, Ref.ID,"alloy_smelter","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                ALLOY_SMELTER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', FURNACE.getItem(LV), 'D', CupronickelHeatingCoil, 'B', PLATE.getMaterialTag(Invar)), "BDB", "CMC", "BcB");
        provider.addItemRecipe(output, Ref.ID,"canner","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                CANNER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', MACHINE_HULLS_BASIC, 'T', PLATE.getMaterialTag(Tin)), "TCT", "TMT", "TcT");
        provider.addItemRecipe(output, Ref.ID,"plate_bender","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                BENDER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', COMPRESSOR.getItem(LV), 'P', PISTONS), "PCP", "McM", "PCP");
        provider.addItemRecipe(output, Ref.ID,"assembler","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                ASSEMBLER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'S', PLATES_STEELS, 'P', PISTONS), "CPC", "ScS", "CSC");
        //provider.addItemRecipe(output, Ref.ID,"printing_factory","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
        //        PRINTING_FACTORY.getItem(LV), of('C', CIRCUITS_BASIC, 'c', ConveyorModule, 'S', PLATES_STEELS, 'P', PISTONS), "SPS", "CcC", "SSS");
        provider.addItemRecipe(output, Ref.ID,"centrifuge","machines", "has_extractor", provider.hasSafeItem(EXTRACTOR.getItem(LV)),
                CENTRIFUGE.getItem(LV), of('C', CIRCUITS_ADVANCED, 'E', EXTRACTOR.getItem(LV), 'S', PLATES_STEELS, 'M', MACHINE_HULLS_BASIC), "SCS", "MEM", "SCS");
        provider.addItemRecipe(output, Ref.ID,"universal_macerator","machines", "has_macerator", provider.hasSafeItem(MACERATOR.getItem(LV)),
                MACERATOR.getItem(MV), of('D', GRINDING_HEAD, 'M', MACERATOR.getItem(LV), 'S', PLATE.getMaterialTag(Titanium), 'H', MACHINE_HULLS_ADVANCED), "SDS", "SMS", "SHS");
        provider.addItemRecipe(output, Ref.ID,"fluid_canner","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                FLUID_CANNER.getItem(LV), of('C', CIRCUITS_BASIC, 'c', CANNER.getItem(LV), 'T', getForgelikeItemTag("plates/tin"), 'P', FLUID_PIPE_BRONZE.getBlockItem(PipeSize.SMALL), 'E', CellTin), " C ", "EcE", "TPT");
        provider.addItemRecipe(output, Ref.ID,"large_gas_turbine","machines", "has_gas_turbine", provider.hasSafeItem(GAS_TURBINE.getItem(LV)),
                LARGE_GAS_TURBINE.getItem(IV), of('G', GAS_TURBINE.getItem(LV), 'T', GEARS_TITAN_TUNGSTEEL, 'H', MACHINE_HULLS_VERY_ADVANCED, 'C', CIRCUITS_MASTER), "GGG", "THT", "GCG");
        provider.addItemRecipe(output, Ref.ID,"large_steam_turbine","machines", "has_steam_turbine", provider.hasSafeItem(STEAM_TURBINE.getItem(LV)),
                LARGE_STEAM_TURBINE.getItem(EV), of('G', STEAM_TURBINE.getItem(LV), 'T', GEARS_STEELS, 'H', MACHINE_HULLS_BASIC, 'C', CIRCUITS_ADVANCED), "GGG", "THT", "GCG");
        provider.addItemRecipe(output, Ref.ID,"thermal_boiler","machines", "has_thermal_generator", provider.hasSafeItem(HEAT_EXCHANGER.getItem(LV)),
                THERMAL_BOILER.getItem(LV), of('G', HEAT_EXCHANGER.getItem(LV), 'T', GEARS_TITAN_TUNGSTEEL, 'M', CENTRIFUGE.getItem(LV), 'C', CIRCUITS_ELITE), "GMG", "TCT", "GMG");
        provider.addItemRecipe(output, Ref.ID,"lathe","machines", "has_conveyor_module", provider.hasSafeItem(ConveyorModule),
                LATHE.getItem(LV), of('c', ConveyorModule, 'G', GEARS_STEELS, 'H', MACHINE_HULLS_BASIC, 'C', CIRCUITS_ADVANCED, 'P',  PLATES_STEELS), "PCP", "GcG", "PHP");
        provider.addItemRecipe(output, Ref.ID,"cutter","machines", "has_sawblade", provider.hasSafeItem(DiamondSawBlade),
                CUTTER.getItem(LV), of('D', DiamondSawBlade, 'G', GEARS_STEELS, 'H', MACHINE_HULLS_BASIC, 'C', CIRCUITS_ADVANCED, 'P',  PLATES_STEELS), "PCP", "GDG", "PHP");
        provider.addItemRecipe(output, Ref.ID, "extruder", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_ADVANCED),
                EXTRUDER.getItem(MV), of2('P', PLATES_TITAN_TUNGSTEEL, 'G', GEARS_TITAN_TUNGSTEEL, 'H', NichromeHeatingCoil, 'M', MACHINE_HULLS_ADVANCED, 'D', DiamondSawBlade, 'C', CIRCUITS_ELITE), "PGP", "HMD", "PCP");
        provider.addItemRecipe(output, Ref.ID,"small_coil_boiler","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                COAL_BOILER.getItem(BRONZE), of( 'P',  getForgelikeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', Items.FURNACE), "PPP", "PWP", "BFB");
        provider.addItemRecipe(output, Ref.ID,"steam_macerator","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_MACERATOR.getItem(BRONZE), of2( 'P',  getForgelikeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'H', HAMMER.getTag(), 'D', GEM.getMaterialTag(Diamond), 'M', MACHINE_HULLS_CHEAP, 'p', PISTONS, 'G', GEAR.getMaterialTag(Bronze)), "WDH", "GMG", "PpP");
        provider.addItemRecipe(output, Ref.ID,"steam_furnace","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_FURNACE.getItem(BRONZE), of( 'P',  getForgelikeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', Items.FURNACE, 'M', MACHINE_HULLS_CHEAP), "PWP", "PFP", "BMB");
        provider.addItemRecipe(output, Ref.ID,"steam_alloy_smelter","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_ALLOY_SMELTER.getItem(BRONZE), of( 'P',  getForgelikeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', STEAM_FURNACE.getItem(BRONZE)), "PPP", "FWF", "BBB");
        provider.addItemRecipe(output, Ref.ID,"steam_forge_hammer","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_FORGE_HAMMER.getItem(BRONZE), of( 'B',  getForgelikeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'G', GEAR.getMaterialTag(Bronze), 'P', PISTONS, 'M', MACHINE_HULLS_CHEAP), "GPG", "BWB", "BMB");
        provider.addItemRecipe(output, Ref.ID,"steam_compressor","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_COMPRESSOR.getItem(BRONZE), of( 'B',  getForgelikeItemTag("plates/bronze"), 'W', WRENCH.getTag(), 'G', GEAR.getMaterialTag(Bronze), 'P', PISTONS, 'M', MACHINE_HULLS_CHEAP), "BGB", "PWP", "BMB");
        provider.addItemRecipe(output, Ref.ID,"steam_extractor","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_EXTRACTOR.getItem(BRONZE), of( 'B',  getForgelikeItemTag("plates/bronze"), 'W', WRENCH.getTag(),'P', PISTONS, 'M', MACHINE_HULLS_CHEAP), "BBB", "PWP", "BMB");
        provider.addItemRecipe(output, Ref.ID,"high_pressure_coil_boiler","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                COAL_BOILER.getItem(STEEL), of( 'P',  PLATES_STEELS, 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', Items.FURNACE), "PPP", "PWP", "BFB");
        provider.addItemRecipe(output, Ref.ID,"high_pressure_coil_boiler_upgrade","machines", "has_bronze_coal_boiler", provider.hasSafeItem(COAL_BOILER.getItem(BRONZE)),
                COAL_BOILER.getItem(STEEL), of( 'P',  PLATES_STEELS, 'C', COAL_BOILER.getItem(BRONZE)), "PPP", "PCP");
        provider.addItemRecipe(output, Ref.ID,"high_pressure_steam_furnace","machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                STEAM_FURNACE.getItem(STEEL), of( 'P',  PLATES_STEELS, 'W', WRENCH.getTag(), 'B', Items.BRICKS, 'F', Items.FURNACE, 'M', MACHINE_HULLS_SEMI_CHEAP), "PWP", "PFP", "BMB");
        provider.addItemRecipe(output, Ref.ID,"high_pressure_furnace_upgrade","machines", "has_bronze_furnace", provider.hasSafeItem(STEAM_FURNACE.getItem(BRONZE)),
                STEAM_FURNACE.getItem(STEEL), of( 'P',  PLATES_STEELS, 'C', STEAM_FURNACE.getItem(BRONZE)), "PPP", "PCP");
        provider.addItemRecipe(output, Ref.ID, "diesel_generator", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                DIESEL_GENERATOR.getItem(LV), of('P', PLATES_WROUGHT_ALUMINIUM, 'B', BatteryRE, 'C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC), "PBP", "P P", "CMC");
        provider.addItemRecipe(output, Ref.ID, "semifluid_generator", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                SEMIFLUID_GENERATOR.getItem(LV), of('P', PLATES_WROUGHT_ALUMINIUM, 'B', BatteryRE, 'C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'R', REINFORCED_GLASS), "PBP", "PRP", "CMC");
        provider.addItemRecipe(output, Ref.ID, "gas_turbine", "machines", "has_windmill", provider.hasSafeItem(WINDMILL.getItem(ULV)),
                GAS_TURBINE.getItem(LV), of('P', PLATES_INVAR_ALUMINIUM, 'W', WINDMILL.getItem(ULV), 'C', CIRCUITS_ADVANCED, 'G', REINFORCED_GLASS), "PCP", "WGW", "PCP");
        //TODO: replace turbine blade with turbine rotor
        provider.addItemRecipe(output, Ref.ID, "steam_turbine", "machines", "has_watermill", provider.hasSafeItem(WATERMILL.getItem(ULV)),
                STEAM_TURBINE.getItem(LV), of('P', PLATES_STEELS, 'M', MACHINE_HULLS_BASIC, 'C', CIRCUITS_BASIC, 'B', GT4RMaterialTags.TURBINE_BLADE.getMaterialTag(Bronze)), "PCP", "BMB", "PCP");
        provider.addItemRecipe(output, Ref.ID, "primitive_blast_furnace", "machines", "has_fire_bricks", provider.hasSafeItem(FireBrick),
                PRIMITIVE_BLAST_FURNACE.getItem(BRONZE), of('B', FireBrick, 'I', PLATE.getMaterialTag(Iron)), "BBB", "BIB", "BBB");
        provider.addItemRecipe(output, Ref.ID, "coke_oven", "machines", "has_fire_bricks", provider.hasSafeItem(FireBrick),
                COKE_OVEN.getItem(LV), of('B', FireBrick), "BBB", "B B", "BBB");
        BATTERY_BUFFER_ONE.getTiers().forEach(t -> {
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_batter_buffer_one", "machines", "has_machine_hull", provider.hasSafeItem(GT4RMaterialTags.HULL.getMaterialTag(TIER_MATERIALS.get(t))),
                    BATTERY_BUFFER_ONE.getItem(t), of('H', GT4RMaterialTags.HULL.get(TIER_MATERIALS.get(t)), 'C', ForgeCTags.CHESTS, 'W', TIER_WIRES.get(t).getBlockItem(PipeSize.VTINY)), "WCW", "WHW");
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_batter_buffer_four", "machines", "has_machine_hull", provider.hasSafeItem(GT4RMaterialTags.HULL.getMaterialTag(TIER_MATERIALS.get(t))),
                    BATTERY_BUFFER_FOUR.getItem(t), of('H', GT4RMaterialTags.HULL.get(TIER_MATERIALS.get(t)), 'C', ForgeCTags.CHESTS, 'W', TIER_WIRES.get(t).getBlockItem(PipeSize.SMALL)), "WCW", "WHW");
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_batter_buffer_eight", "machines", "has_machine_hull", provider.hasSafeItem(GT4RMaterialTags.HULL.getMaterialTag(TIER_MATERIALS.get(t))),
                    BATTERY_BUFFER_EIGHT.getItem(t), of('H', GT4RMaterialTags.HULL.get(TIER_MATERIALS.get(t)), 'C', ForgeCTags.CHESTS, 'W', TIER_WIRES.get(t).getBlockItem(PipeSize.NORMAL)), "WCW", "WHW");
        });
        provider.addItemRecipe(output, Ref.ID, "drum_bronze", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                BRONZE_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Bronze), 'P', PLATE.getMaterialTag(Bronze)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_steel", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                STEEL_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Steel), 'P', PLATE.getMaterialTag(Steel)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_invar", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                INVAR_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Invar), 'P', PLATE.getMaterialTag(Invar)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_stainless_steel", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                STAINLESS_STEEL_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(StainlessSteel), 'P', PLATE.getMaterialTag(StainlessSteel)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_netherite", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                NETHERITE_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Netherite), 'P', PLATE.getMaterialTag(Netherite)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_tungsten", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                TUNGSTEN_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(Tungsten), 'P', PLATE.getMaterialTag(Tungsten)), " H ", "PRP", "PRP");
        provider.addItemRecipe(output, Ref.ID, "drum_tungstensteel", "drums", "has_hammer", provider.hasSafeItem(HAMMER.getTag()),
                TUNGSTENSTEEL_DRUM.getItem(LV), of('H', HAMMER.getTag(), 'R', ROD.getMaterialTag(TungstenSteel), 'P', PLATE.getMaterialTag(TungstenSteel)), " H ", "PRP", "PRP");
        TRANSFORMER.getTiers().forEach(t -> {
            provider.addItemRecipe(output, Ref.ID, t.getId() + "_transformer", "machines", "has_machine_hull", provider.hasSafeItem(GT4RMaterialTags.HULL.getMaterialTag(TIER_MATERIALS.get(t))),
                    TRANSFORMER.getItem(t), of( 'C', TIER_CABLES.get(t).getBlockItem(PipeSize.VTINY), 'M', GT4RMaterialTags.HULL.getMaterialTag(TIER_MATERIALS.get(t)), 'c', TIER_CABLES.get(Tier.getTier(t.getVoltage() * 4)).getBlockItem(PipeSize.VTINY))," CC", "cM ", " CC");
        });
        provider.addItemRecipe(output, Ref.ID, "disassembler", "machines", "has_assembler", provider.hasSafeItem(ASSEMBLER.getItem(LV)),
                DISASSEMBLER.getItem(LV), of('R', PLATES_STEELS, 'A', EXTRACTOR.getItem(LV), 'W', ASSEMBLER.getItem(LV), 'E', CABLE_TIN.getBlockItem(PipeSize.VTINY), 'C', CIRCUITS_ADVANCED), "RAR", "ECE", "RWR");
        provider.addItemRecipe(output, Ref.ID, "pump", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                PUMP.getItem(LV), of('c', CellTin, 'C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'P', FLUID_PIPE_BRONZE.getBlockItem(PipeSize.SMALL)),"cCc", "cMc", "PPP");
        provider.addItemRecipe(output, Ref.ID, "ore_washer", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                ORE_WASHER.getItem(LV), of('m', MotorLV, 'C', CIRCUITS_BASIC, 'M', MACHINE_HULLS_BASIC, 'P', PLATE.getMaterialTag(Iron), 'B', Items.BUCKET),"PPP", "BMB", "mCm");
        provider.addItemRecipe(output, Ref.ID, "thermal_centrifuge", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_ADVANCED),
                THERMAL_CENTRIFUGE.getItem(MV), of('m', MotorMV, 'C', CopperCoil, 'M', MACHINE_HULLS_ADVANCED, 'P', PLATE.getMaterialTag(WroughtIron)),"CmC", "PMP", "PmP");
        provider.addItemRecipe(output, Ref.ID, "watermill", "machines", "has_hull", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                WATERMILL.getItem(ULV), of('M', MACHINE_HULLS_BASIC, 'P', PLATE.getMaterialTag(Steel), 'T', GT4RMaterialTags.TURBINE_BLADE.getMaterialTag(Bronze), 'C', CopperCoil),"PTP", "CMC", "PTP");
        provider.addItemRecipe(output, Ref.ID, "bath", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                BATH.getItem(LV), of('S', PLATE.getMaterialTag(StainlessSteel), 'M', MACHINE_HULLS_BASIC), "SSS", "S S", "SMS");
        provider.addItemRecipe(output, Ref.ID, "sifter", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                SIFTER.getItem(LV), of('I', ItemFilter, 'M', MACHINE_HULLS_BASIC, 'P', PISTONS, 'C', CIRCUITS_BASIC), " I ", "PMP", "CIC");
        provider.addItemRecipe(output, Ref.ID, "recycler", "machines", "has_compressor", provider.hasSafeItem(COMPRESSOR.getItem(LV)),
                RECYCLER.getItem(LV), of('G', DUST.getMaterialTag(Glowstone), 'C', COMPRESSOR.getItem(LV), 'D', Items.DIRT, 'S', PLATES_STEELS), " G ", "DCD", "SDS");
        provider.addItemRecipe(output, Ref.ID, "heat_exchanger", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                HEAT_EXCHANGER.getItem(LV), of('I', PLATE.getMaterialTag(Invar), 'C', CopperCoil, 'P', FLUID_PIPE_INVAR.getBlock(PipeSize.SMALL), 'M', MACHINE_HULLS_BASIC), "ICI", "PMP", "ICI");
        provider.addItemRecipe(output, Ref.ID, "dustbin", "machines", "has_wrench", provider.hasSafeItem(WRENCH.getTag()),
                DUSTBIN.getItem(LV), of2('H', HAMMER.getTag(), 'W', WRENCH.getTag(), 'S', SAW.getTag(), 'P', PLATES_STEELS, 'h', Items.HOPPER, 'R', RODS_STEELS), "HWS", "PhP", "RPR");
        provider.addItemRecipe(output, Ref.ID, "electric_item_translocator", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                ELECTRIC_ITEM_TRANSLOCATOR.getItem(LV), of('B', BatteryRE, 'E', PLATE.getMaterialTag(Electrum), 'C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', MACHINE_HULLS_BASIC), "EBE", "CcC", "EME");
        provider.addItemRecipe(output, Ref.ID, "electric_fluid_translocator", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                ELECTRIC_FLUID_TRANSLOCATOR.getItem(LV), of('B', BatteryRE, 'E', PLATE.getMaterialTag(Electrum), 'C', CIRCUITS_BASIC, 'c', Drain, 'M', MACHINE_HULLS_BASIC), "EBE", "CcC", "EME");
        provider.addItemRecipe(output, Ref.ID, "electric_item_filter", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                ELECTRIC_ITEM_FILTER.getItem(LV), of2('B', ItemFilter, 'E', PLATES_IRON_ALUMINIUM, 'C', CIRCUITS_BASIC, 'c', ConveyorModule, 'M', MACHINE_HULLS_BASIC, 'h', ForgeCTags.CHESTS_WOODEN), "EBE", "hMc", "ECE");
        provider.addItemRecipe(output, Ref.ID, "electric_type_filter", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC),
                ELECTRIC_TYPE_FILTER.getItem(LV), of2('B', ItemFilter, 'E', PLATES_IRON_ALUMINIUM, 'C', CIRCUITS_ADVANCED, 'c', ConveyorModule, 'M', MACHINE_HULLS_BASIC, 'h', ForgeCTags.CHESTS_WOODEN), "EBE", "hMc", "ECE");
        provider.addItemRecipe(output, Ref.ID, "digital_tank", "machines", "has_data_orb", provider.hasSafeItem(CircuitDataOrb),
                DIGITAL_TANK.getItem(LV), of('S', PLATES_STEELS, 'D', CircuitDataOrb, 'C', ComputerMonitor), "SSS", "SDS", "SCS");
        provider.addItemRecipe(output, Ref.ID, "digital_chest", "machines", "has_data_orb", provider.hasSafeItem(CircuitDataOrb),
                DIGITAL_CHEST.getItem(LV), of('P', PLATE.getMaterialTag(Platinum), 'D', CircuitDataOrb, 'C', ComputerMonitor, 'S', CIRCUITS_ELITE), "PPP", "SDS", "PCP");
        provider.addItemRecipe(output, Ref.ID, "quantum_tank", "machines", "has_quantum_chest", provider.hasSafeItem(QUANTUM_CHEST.getItem(MAX)),
                QUANTUM_TANK.getItem(MAX), of('P', PLATE.getMaterialTag(Platinum), 'Q', QUANTUM_CHEST.getItem(MAX), 'C', CIRCUITS_MASTER), "CPC", "PQP", "CPC");
        provider.addItemRecipe(output, Ref.ID, "quantum_chest", "machines", "has_data_orb", provider.hasSafeItem(CircuitDataOrb),
                QUANTUM_CHEST.getItem(MAX), ImmutableMap.<Character, Object>builder().put('D', CircuitDataOrb).put('C', ComputerMonitor).put('H', HIGHLY_ADVANCED_MACHINE_BLOCK).put('T', TELEPORTER.getItem(HV)).put('d', DIGITAL_CHEST.getItem(LV)).build(), "DCD", "HTH", "DdD");
        GT4RMaterialTags.CABINET.all().forEach(m -> {
            provider.addItemRecipe(output, Ref.ID, "cabinet_" + m.getId(), "machines", "has_chest", provider.hasSafeItem(ForgeCTags.CHESTS_WOODEN), Machine.get(m.getId() + "_cabinet", Ref.ID).map(mch -> mch.getItem(LV)).orElse(Items.AIR), of('P', PLATE.getMaterialTag(m), 'C', ForgeCTags.CHESTS_WOODEN), "PPP", "CPC", "PPP");
            provider.addItemRecipe(output, Ref.ID, "chest_" + m.getId(), "machines", "has_chest", provider.hasSafeItem(ForgeCTags.CHESTS_WOODEN), Machine.get(m.getId() + "_chest", Ref.ID).map(mch -> mch.getItem(LV)).orElse(Items.AIR), of('P', PLATE.getMaterialTag(m), 'C', ForgeCTags.CHESTS_WOODEN, 'R', ROD.getMaterialTag(m), 'S', SAW.getTag(), 'W', WRENCH.getTag()), "SPW", "RCR", "PPP");
        });
        GT4RMaterialTags.WORKBENCH.all().forEach(m -> {
            provider.addItemRecipe(output, Ref.ID, "workbench_" + m.getId(), "machines", "has_chest", provider.hasSafeItem(ForgeCTags.CHESTS_WOODEN), Machine.get(m.getId() + "_workbench", Ref.ID).map(mch -> mch.getItem(LV)).orElse(Items.AIR), of('P', PLATE.getMaterialTag(m), 'C', ForgeCTags.CHESTS_WOODEN, 'c', Items.CRAFTING_TABLE, 'S', SCREWDRIVER.getTag()), "PSP", "PcP", "PCP");
        });
        GT4RMaterialTags.CHARGING_WORKBENCH.all().forEach(m -> {
            provider.addItemRecipe(output, Ref.ID, "charging_workbench_" + m.getId(), "machines", "has_chest", provider.hasSafeItem(ForgeCTags.CHESTS_WOODEN), Machine.get(m.getId() + "_charging_workbench", Ref.ID).map(mch -> mch.getItem(HV)).orElse(Items.AIR), of2('S', SCREWDRIVER.getTag(), 'w', WIRE_CUTTER.getTag(), 'W', Machine.get(m.getId() + "_workbench", Ref.ID).map(mch -> mch.getItem(LV)).orElse(Items.AIR), 'c', CABLE_GOLD.getBlockItem(PipeSize.SMALL), 'C', CIRCUITS_ADVANCED, 'R', ROD.getMaterialTag(m)), "RCR", "SWw", "ccc");
        });
        GT4RMaterialTags.LOCKER.all().forEach(m -> {
            provider.addItemRecipe(output, Ref.ID, "locker_" + m.getId(), "machines", "has_chest", provider.hasSafeItem(Machine.get(m.getId() + "_cabinet", Ref.ID).map(mch -> mch.getItem(LV)).orElse(Items.AIR)), Machine.get(m.getId() + "_locker", Ref.ID).map(mch -> mch.getItem(LV)).orElse(Items.AIR), of('P', PLATE.getMaterialTag(m), 'R', ROD.getMaterialTag(m), 'L', Items.LEATHER, 'C', Machine.get(m.getId() + "_cabinet", Ref.ID).map(mch -> mch.getItem(LV)).orElse(Items.AIR), 'M', GT4RMaterialTags.HULL.getMaterialTag(m)), "RLR", "LCL", "PMP");
        });
        GT4RMaterialTags.CHARGING_LOCKER.all().forEach(m -> {
            provider.addItemRecipe(output, Ref.ID, "charging_locker_" + m.getId(), "machines", "has_chest", provider.hasSafeItem(Machine.get(m.getId() + "_locker", Ref.ID).map(mch -> mch.getItem(LV)).orElse(Items.AIR)), Machine.get(m.getId() + "_charging_locker", Ref.ID).map(mch -> mch.getItem(HV)).orElse(Items.AIR), of('L', Machine.get(m.getId() + "_locker", Ref.ID).map(mch -> mch.getItem(LV)).orElse(Items.AIR), 'c', CABLE_GOLD.getBlockItem(PipeSize.VTINY), 'C', CIRCUITS_ADVANCED), "cCc", "cLc", "cCc");
        });
        provider.addItemRecipe(output, Ref.ID, "fermenter", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), FERMENTER.getItem(LV), of('C', CIRCUITS_BASIC, 'G', ForgeCTags.GLASS, 'M', MACHINE_HULLS_BASIC, 'P', PumpModule), " P ", "GMG", " C ");
        provider.addItemRecipe(output, Ref.ID, "distillery", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), DISTILLERY.getItem(LV), of('C', CIRCUITS_BASIC, 'G', ForgeCTags.GLASS, 'M', MACHINE_HULLS_BASIC, 'P', PumpModule, 'B', ROD.getMaterialTag(Blaze)), " B ", "CMC", "GPG");
        provider.addItemRecipe(output, Ref.ID, "fluid_extractor", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), FLUID_EXTRACTOR.getItem(LV), of('C', CIRCUITS_BASIC, 'G', ForgeCTags.GLASS, 'M', MACHINE_HULLS_BASIC, 'P', PISTONS, 'p', PumpModule), " C ", "pMP", "GCG");
        provider.addItemRecipe(output, Ref.ID, "fluid_solidifier", "machines", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), FLUID_SOLIDIFIER.getItem(LV), of('C', CIRCUITS_BASIC, 'G', ForgeCTags.GLASS, 'M', MACHINE_HULLS_BASIC, 'P', PumpModule, 'c', ForgeCTags.CHESTS_WOODEN), " G ", "PMP", "CcC");
        provider.addItemRecipe(output, Ref.ID, "item_input_hatch", "hatches", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), HATCH_ITEM_I.getItem(LV), of('P', PLATE.getMaterialTag(StainlessSteel), 'G', GEARS_STEELS, 'M', MACHINE_HULLS_BASIC, 'C', ForgeCTags.CHESTS_WOODEN), "PCP", "GMG", "PPP");
        provider.addItemRecipe(output, Ref.ID, "item_output_hatch", "hatches", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), HATCH_ITEM_O.getItem(LV), of('P', PLATE.getMaterialTag(StainlessSteel), 'G', GEARS_STEELS, 'M', MACHINE_HULLS_BASIC, 'C', ForgeCTags.CHESTS_WOODEN), "PPP", "GMG", "PCP");
        provider.addItemRecipe(output, Ref.ID, "fluid_input_hatch", "hatches", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), HATCH_FLUID_I.getItem(LV), of('P', PLATE.getMaterialTag(StainlessSteel), 'G', GEARS_STEELS, 'M', MACHINE_HULLS_BASIC, 'C', ForgeCTags.GLASS), "PCP", "GMG", "PPP");
        provider.addItemRecipe(output, Ref.ID, "fluid_output_hatch", "hatches", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), HATCH_FLUID_O.getItem(LV), of('P', PLATE.getMaterialTag(StainlessSteel), 'G', GEARS_STEELS, 'M', MACHINE_HULLS_BASIC, 'C', ForgeCTags.GLASS), "PPP", "GMG", "PCP");
        provider.addItemRecipe(output, Ref.ID, "ev_dynamo_hatch", "hatches", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), HATCH_DYNAMO.getItem(EV), of('P', PLATE.getMaterialTag(StainlessSteel), 'G', GEARS_STEELS, 'M', MACHINE_HULLS_BASIC, 'C', TIER_CABLES.get(EV).getBlock(PipeSize.VTINY)), "PPP", "GMG", "PCP");
        provider.addItemRecipe(output, Ref.ID, "iv_dynamo_hatch", "hatches", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), HATCH_DYNAMO.getItem(IV), of('P', PLATE.getMaterialTag(StainlessSteel), 'G', GEARS_STEELS, 'M', MACHINE_HULLS_BASIC, 'C', TIER_CABLES.get(IV).getBlock(PipeSize.VTINY)), "PPP", "GMG", "PCP");
        provider.addItemRecipe(output, Ref.ID, "fusion_item_injector", "hatches", "has_machine_hull_highly_advanced", provider.hasSafeItem(HIGHLY_ADVANCED_MACHINE_BLOCK), FUSION_ITEM_INJECTOR.getItem(LV), of('P', ConveyorModule, 'c', CIRCUITS_MASTER, 'M', HIGHLY_ADVANCED_MACHINE_BLOCK, 'C', ForgeCTags.CHESTS_WOODEN), "PCP", "cMc", "PcP");
        provider.addItemRecipe(output, Ref.ID, "fusion_item_extractor", "hatches", "has_machine_hull_highly_advanced", provider.hasSafeItem(HIGHLY_ADVANCED_MACHINE_BLOCK), FUSION_ITEM_EXTRACTOR.getItem(LV), of('P', ConveyorModule, 'c', CIRCUITS_MASTER, 'M', HIGHLY_ADVANCED_MACHINE_BLOCK, 'C', ForgeCTags.CHESTS_WOODEN), "PcP", "cMc", "PCP");
        provider.addItemRecipe(output, Ref.ID, "fusion_fluid_injector", "hatches", "has_machine_hull_highly_advanced", provider.hasSafeItem(HIGHLY_ADVANCED_MACHINE_BLOCK), FUSION_FLUID_INJECTOR.getItem(LV), of('P', PumpModule, 'c', CIRCUITS_MASTER, 'M', HIGHLY_ADVANCED_MACHINE_BLOCK, 'C', ForgeCTags.GLASS), "PCP", "cMc", "PcP");
        provider.addItemRecipe(output, Ref.ID, "fusion_fluid_extractor", "hatches", "has_machine_hull_highly_advanced", provider.hasSafeItem(HIGHLY_ADVANCED_MACHINE_BLOCK), FUSION_FLUID_EXTRACTOR.getItem(LV), of('P', PumpModule, 'c', CIRCUITS_MASTER, 'M', HIGHLY_ADVANCED_MACHINE_BLOCK, 'C', ForgeCTags.GLASS), "PcP", "cMc", "PCP");
        provider.addItemRecipe(output, Ref.ID, "fusion_energy_injector", "hatches", "has_supercondensator", provider.hasSafeItem(SUPERCONDENSATOR.getItem(LUV)), FUSION_ENERGY_INJECTOR.getItem(IV), of('S', ItemSuperconductor, 'C', CIRCUITS_MASTER, 'T', SUPERCONDENSATOR.getItem(LUV)), "SCS", "CTC", "SCS");
        provider.addItemRecipe(output, Ref.ID, "supercondensator", "machines", "has_machine_hull_highly_advanced", provider.hasSafeItem(HIGHLY_ADVANCED_MACHINE_BLOCK), SUPERCONDENSATOR.getItem(LUV), of('C', CIRCUITS_MASTER, 'L', LapotronicEnergyOrb, 'S', ItemSuperconductor, 'M', HIGHLY_ADVANCED_MACHINE_BLOCK), "CLC", "SMS", "CLC");
        provider.addItemRecipe(output, Ref.ID, "muffler_hatch", "hatches", "has_machine_hull_basic", provider.hasSafeItem(MACHINE_HULLS_BASIC), HATCH_MUFFLER.getItem(LV), of('P', PLATE.getMaterialTag(StainlessSteel), 'G', GEARS_STEELS, 'M', MACHINE_HULLS_BASIC, 'C', REINFORCED_GLASS), "PMP", "GCG", "PCP");
        provider.addItemRecipe(output, Ref.ID, "hv_teleporter", "machines", "has_machine_hull_stabilized", provider.hasSafeItem(MACHINE_HULLS_STABILIZED), TELEPORTER.getItem(HV), of('C', CIRCUITS_ADVANCED, 'S', MACHINE_HULLS_STABILIZED, 'D', GEM.getMaterialTag(Diamond), 'c', CABLE_ELECTRUM.getBlock(PipeSize.TINY), 'f', FrequencyTransmitter), "CfC", "cSc", "CDC");
        provider.addItemRecipe(output, Ref.ID, "luv_teleporter", "machines", "has_machine_hull_highly_advanced", provider.hasSafeItem(HIGHLY_ADVANCED_MACHINE_BLOCK), TELEPORTER.getItem(LUV), of('T', TELEPORTER.getItem(HV), 'M', HIGHLY_ADVANCED_MACHINE_BLOCK, 'L', LapotronicEnergyOrb, 'C', CIRCUITS_MASTER), "CTC", "TMT", "CLC");
    }
}