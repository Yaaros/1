package com.yaaros.panic.world.feature;

import com.yaaros.panic.panic;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;


public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, panic.MOD_ID);

    public static final RegistryObject<PlacedFeature> CELESTINE_ORE_PLACED =
            PLACED_FEATURES.register("celestine_ore_placed",()->
                    new PlacedFeature(ModConfiguredFeatures.CELESTINE_ORE.getHolder().get(),
                            commonOrePlacement(7,
                                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80),
                                            VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> END_CELESTINE_ORE_PLACED =
            PLACED_FEATURES.register("end_celestine_ore_placed",()->
                    new PlacedFeature(ModConfiguredFeatures.END_CELESTINE_ORE.getHolder().get(),
                            commonOrePlacement(7,
                                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80),
                                            VerticalAnchor.aboveBottom(80)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier1) {
        return List.of(modifier, InSquarePlacement.spread(), modifier1, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }


    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
