package com.yaaros.panic.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.yaaros.panic.block.ModBlocks;
import com.yaaros.panic.panic;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES=
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, panic.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CELESTINE_ORES =
            Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                    ModBlocks.CELESTINE_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                    ModBlocks.DEEPSLATE_CELESTINE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_CELESTINE_ORES =
            Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE),
                    ModBlocks.END_CELESTINE_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?,?>> CELESTINE_ORE =
            CONFIGURED_FEATURES.register("celestine_ore",()-> new ConfiguredFeature<>(Feature.ORE,
                    new OreConfiguration(OVERWORLD_CELESTINE_ORES.get(),7)));
    public static final RegistryObject<ConfiguredFeature<?,?>> END_CELESTINE_ORE =
            CONFIGURED_FEATURES.register("end_celestine_ore",()-> new ConfiguredFeature<>(Feature.ORE,
                    new OreConfiguration(END_CELESTINE_ORES.get(),9)));

    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
