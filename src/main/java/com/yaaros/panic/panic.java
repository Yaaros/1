package com.yaaros.panic;

import com.mojang.logging.LogUtils;
import com.yaaros.panic.block.ModBlocks;
import com.yaaros.panic.client.GhastRenderer;
import com.yaaros.panic.entity.ModEntityTypes;
import com.yaaros.panic.entity.custom.GhastEntity;
import com.yaaros.panic.item.ModItems;
import com.yaaros.panic.villager.ModVillagers;
import com.yaaros.panic.world.feature.ModConfiguredFeatures;
import com.yaaros.panic.world.feature.ModPlacedFeatures;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(panic.MOD_ID)
public class panic
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "panic";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public panic() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);

        ModPlacedFeatures.register(modEventBus);

        ModEntityTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModVillagers::registerPOIs);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {


        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.Ghast_Y.get(), GhastRenderer::new);

        }
    }
}
