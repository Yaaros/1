package com.yaaros.panic.event;


import com.yaaros.panic.block.ModBlocks;
import com.yaaros.panic.entity.ModEntityTypes;
import com.yaaros.panic.entity.custom.GhastEntity;
import com.yaaros.panic.item.ModItems;
import com.yaaros.panic.panic;
import com.yaaros.panic.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


public class ModEvents {
    @Mod.EventBusSubscriber(modid = panic.MOD_ID)
    public static class ForgeEvents{
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            if (event.getType() == VillagerProfession.TOOLSMITH) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.EIGHT_BALL.get(), 1);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        stack, 10, 8, 0.02F));
            }

            if (event.getType() == ModVillagers.Wizard.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.PENTAGRAM.get(), 1);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        stack, 10, 8, 0.02F));
            }
            if (event.getType() == ModVillagers.Lexicy.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModBlocks.Trampoline.get(), 1);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 2),
                        stack, 10, 8, 0.02F));
            }
        }
    }
    @Mod.EventBusSubscriber(modid = panic.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModEventBusEvents{
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.Ghast_Y.get(), GhastEntity.setAttributes());
        }
    }

}
