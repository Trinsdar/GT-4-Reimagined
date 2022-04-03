package trinsdar.gt4r.loader.machines;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.ore.BlockOre;
import muramasa.antimatter.ore.CobbleStoneType;
import muramasa.antimatter.ore.StoneType;
import muramasa.antimatter.pipe.PipeSize;
import muramasa.antimatter.pipe.types.FluidPipe;
import muramasa.antimatter.pipe.types.ItemPipe;
import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import muramasa.antimatter.recipe.map.RecipeMap;
import muramasa.antimatter.util.TagUtils;
import muramasa.antimatter.util.Utils;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import trinsdar.gt4r.Ref;
import trinsdar.gt4r.data.GT4RData;

import java.util.ArrayList;
import java.util.List;

import static muramasa.antimatter.Data.*;
import static muramasa.antimatter.util.Utils.getConventionalMaterialType;
import static muramasa.antimatter.util.Utils.getConventionalStoneType;
import static trinsdar.gt4r.data.GT4RData.Biochaff;
import static trinsdar.gt4r.data.GT4RData.Plantball;
import static trinsdar.gt4r.data.Materials.Brick;
import static trinsdar.gt4r.data.Materials.Clay;
import static trinsdar.gt4r.data.Materials.Limestone;
import static trinsdar.gt4r.data.Materials.Scoria;
import static trinsdar.gt4r.data.RecipeMaps.EXTRUDING;
import static trinsdar.gt4r.data.RecipeMaps.MACERATING;
import static trinsdar.gt4r.data.RecipeMaps.SIFTING;

public class MaceratorLoader {
    public static void initManual(){
        MACERATING.RB().ii(RecipeIngredient.of(Items.STONE, 1)).io(new ItemStack(Items.GRAVEL)).add(400, 2);
        MACERATING.RB().ii(RecipeIngredient.of(Items.BRICK, 1)).io(DUST_SMALL.get(Brick, 1)).add(25, 2);
        MACERATING.RB().ii(RecipeIngredient.of(Items.CLAY_BALL, 1)).io(DUST_SMALL.get(Clay, 2)).add(16, 4);
        MACERATING.RB().ii(RecipeIngredient.of(Plantball, 1)).io(new ItemStack(Biochaff, 1)).add(300, 2);
        MACERATING.RB().ii(RecipeIngredient.of(Biochaff, 1)).io(new ItemStack(Items.DIRT, 1)).add(300, 2);
        MACERATING.RB().ii(RecipeIngredient.of(Items.CLAY, 1)).io(DUST.get(Clay, 2)).add(30, 4);
        MACERATING.RB().ii(RecipeIngredient.of(Items.TERRACOTTA, 1)).io(DUST.get(Clay, 1)).add(16, 4);
        MACERATING.RB().ii(RecipeIngredient.of(Items.BRICKS, 1)).io(DUST.get(Brick, 1)).add(100, 2);
        MACERATING.RB().ii(RecipeIngredient.of(ItemTags.LOGS, 1)).io(DUST.get(Wood, 6)).add(400, 2);
        MACERATING.RB().ii(RecipeIngredient.of(Items.PRISMARINE, 1)).io(DUST.get(Prismarine, 1)).add(400, 2);
        MACERATING.RB().ii(RecipeIngredient.of(Items.DARK_PRISMARINE, 1)).io(DUST.get(DarkPrismarine, 1)).add(400, 2);
        if (AntimatterAPI.isModLoaded(Ref.MOD_CREATE)){
            MACERATING.RB().ii(RecipeIngredient.of(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Ref.MOD_CREATE, "limestone")), 1)).io(DUST.get(Limestone, 1)).add(400, 2);
            MACERATING.RB().ii(RecipeIngredient.of(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Ref.MOD_CREATE, "weathered_limestone")), 1)).io(DUST.get(Limestone, 1)).add(400, 2);
            MACERATING.RB().ii(RecipeIngredient.of(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Ref.MOD_CREATE, "scoria")), 1)).io(DUST.get(Scoria, 1)).add(400, 2);
            MACERATING.RB().ii(RecipeIngredient.of(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Ref.MOD_CREATE, "dark_scoria")), 1)).io(DUST.get(Scoria, 1)).add(400, 2);
        }
    }

    public static void initAuto() {
        AntimatterAPI.all(BlockOre.class, o -> {
            if (o.getOreType() != ORE) return;
            Material m = o.getMaterial();
            Material sm = o.getStoneType().getMaterial();
            if (!m.has(DUST) || !m.has(CRUSHED)) return;
            ItemStack stoneDust = sm.has(DUST) ? DUST.get(sm, 1) : ItemStack.EMPTY;
            TagKey<Item> oreTag = TagUtils.getForgeItemTag(String.join("", getConventionalStoneType(o.getStoneType()), "_", getConventionalMaterialType(o.getOreType()), "/", o.getMaterial().getId()));
            RecipeIngredient ore = RecipeIngredient.of(oreTag,1);
            ItemStack crushedStack = CRUSHED.get(m,m.getOreMulti());
            Material oreByProduct1 = m.getByProducts().size() > 0 ? m.getByProducts().get(0) : m.getMacerateInto();
            RecipeMap rm = MACERATING;
            if (sm == Sand || sm == RedSand || sm == Gravel){
                rm = SIFTING;
            }
            List<ItemStack> stacks = new ArrayList<>();
            stacks.add(Utils.ca((m.getOreMulti()) * (rm == SIFTING ? 1 : 2), crushedStack));
            if (rm == SIFTING) stacks.add(crushedStack);
            stacks.add(DUST.get(oreByProduct1, 1));
            if (!stoneDust.isEmpty()) stacks.add(stoneDust);
            ItemStack[] stackArray = stacks.toArray(new ItemStack[0]);
            List<Integer> ints = new ArrayList<>();
            ints.add(100);
            if (rm == SIFTING) ints.add(50);
            ints.add(10 * m.getByProductMulti());
            if (!stoneDust.isEmpty()) ints.add(50);
            int[] chances = ints.stream().mapToInt(i -> i).toArray();
            rm.RB().ii(ore).io(stackArray).chances(chances).add(400, 2);
        });
        CRUSHED.all().forEach(m -> {
            if (!m.has(ORE) && m != NetheriteScrap) return;
            int multiplier = 1;
            RecipeIngredient ore = RecipeIngredient.of(ORE.getMaterialTag(m),1);
            RecipeIngredient crushed = RecipeIngredient.of(CRUSHED.getMaterialTag(m), 1);
            ItemStack crushedStack = CRUSHED.get(m,1);
            ItemStack stoneDust = DUST.get(Stone, 1);

            //TODO better way to do this
            Material oreByProduct1 = m.getByProducts().size() > 0 ? m.getByProducts().get(0) : m.getMacerateInto();
            Material oreByProduct2 = m.getByProducts().size() > 1 ? m.getByProducts().get(1) : oreByProduct1;
            Material oreByProduct3 = m.getByProducts().size() > 2 ? m.getByProducts().get(2) : oreByProduct2;

            if (m == NetheriteScrap){
                MACERATING.RB().ii(ore).io(Utils.ca((m.getOreMulti() * multiplier) * 2, crushedStack), DUST.get(oreByProduct1, 1), DUST.get(Netherrack, 1)).chances(100, 10 * multiplier * m.getByProductMulti(), 50).add(400, 2);
            }
            MACERATING.RB().ii(crushed).io(DUST_IMPURE.get(m.getMacerateInto(), 1), DUST.get(oreByProduct1, 1)).chances(100, 10).add(400, 2);
            MACERATING.RB().ii(RecipeIngredient.of(CRUSHED_PURIFIED.getMaterialTag(m), 1)).io(DUST_PURE.get(m.getMacerateInto(), 1), DUST.get(oreByProduct2, 1)).chances(100, 10).add(400, 2);
            MACERATING.RB().ii(RecipeIngredient.of(CRUSHED_CENTRIFUGED.getMaterialTag(m), 1)).io(DUST.get(m.getMacerateInto(), 1), DUST.get(oreByProduct3, 1)).chances(100, 10).add(400, 2);
            if (m.has(RAW_ORE)){
                MACERATING.RB().ii(RecipeIngredient.of(RAW_ORE.getMaterialTag(m), 1)).io(Utils.ca((m.getOreMulti() * multiplier) * 2, crushedStack), DUST.get(oreByProduct1, 1)).chances(100, 10 * multiplier * m.getByProductMulti()).add(400, 2);
            }
        });
        DUST.all().forEach(m -> {
            if (m.has(PLATE) && m != Wood){
                long duration = m.getMass();
                MACERATING.RB().ii(PLATE.getMaterialIngredient(m, 1)).io(DUST.get(m, 1)).add(duration, 4);
            }
            if (m.has(INGOT)){
                long duration = m.getMass();
                MACERATING.RB().ii(INGOT.getMaterialIngredient(m, 1)).io(DUST.get(m, 1)).add(duration, 4);
            }
            if (m.has(GEM)){
                long duration = m.getMass();
                MACERATING.RB().ii(GEM.getMaterialIngredient(m, 1)).io(DUST.get(m, 1)).add(duration, 4);
            }
        });
        AntimatterAPI.all(StoneType.class, s -> {
            if (s.getMaterial() == NULL || !s.getMaterial().has(DUST)) return;
            MACERATING.RB().ii(RecipeIngredient.of(s.getState().getBlock().asItem(), 1)).io(DUST.get(s.getMaterial(), 1)).add(400, 2);
            if (s instanceof CobbleStoneType){
                MACERATING.RB().ii(RecipeIngredient.of(((CobbleStoneType)s).getBlock("cobble").asItem(), 1)).io(DUST.get(s.getMaterial(), 1)).add(400, 2);
            }
        });
        AntimatterAPI.all(FluidPipe.class).forEach(t -> {
            if (!t.getMaterial().has(DUST) || t.getMaterial() == Wood) return;
            Item pipeTiny = t.getBlockItem(PipeSize.TINY);
            Item pipeSmall = t.getBlockItem(PipeSize.SMALL);
            Item pipeNormal = t.getBlockItem(PipeSize.NORMAL);
            Item pipeLarge = t.getBlockItem(PipeSize.LARGE);
            Item pipeHuge = t.getBlockItem(PipeSize.HUGE);
            MACERATING.RB().ii(RecipeIngredient.of(pipeTiny, 1)).io(DUST_SMALL.get(t.getMaterial(), 2)).add(t.getMaterial().getMass()/2,128);
            MACERATING.RB().ii(RecipeIngredient.of(pipeSmall, 1)).io(DUST.get(t.getMaterial(), 1)).add(t.getMaterial().getMass(),128);
            MACERATING.RB().ii(RecipeIngredient.of(pipeNormal, 1)).io(DUST.get(t.getMaterial(), 3)).add(t.getMaterial().getMass()*3,128);
            MACERATING.RB().ii(RecipeIngredient.of(pipeLarge, 1)).io(DUST.get(t.getMaterial(), 6)).add(t.getMaterial().getMass()*6,128);
            MACERATING.RB().ii(RecipeIngredient.of(pipeHuge, 1)).io(DUST.get(t.getMaterial(), 12)).add(t.getMaterial().getMass()*12,128);
        });

        AntimatterAPI.all(ItemPipe.class).forEach(t -> {
            if (!t.getMaterial().has(INGOT)) return;
            Item pipeNormal = t.getBlockItem(PipeSize.NORMAL);
            Item pipeLarge = t.getBlockItem(PipeSize.LARGE);
            Item pipeHuge = t.getBlockItem(PipeSize.HUGE);
            MACERATING.RB().ii(RecipeIngredient.of(pipeNormal, 1)).io(DUST.get(t.getMaterial(), 3)).add(t.getMaterial().getMass()*3,128);
            MACERATING.RB().ii(RecipeIngredient.of(pipeLarge, 1)).io(DUST.get(t.getMaterial(), 6)).add(t.getMaterial().getMass()*6,128);
            MACERATING.RB().ii(RecipeIngredient.of(pipeHuge, 1)).io(DUST.get(t.getMaterial(), 12)).add(t.getMaterial().getMass()*12,128);
        });

    }
}
