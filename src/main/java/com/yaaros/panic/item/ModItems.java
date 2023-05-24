package com.yaaros.panic.item;

import com.yaaros.panic.entity.ModEntityTypes;
import com.yaaros.panic.item.custom.DiceItem;
import com.yaaros.panic.panic;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, panic.MOD_ID);
    //正式注册物品，首个参数为物品注册名
    public static final RegistryObject<Item> CELESTINE = ITEMS.register("celestine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Test_TAB).stacksTo(64)));
    public static final RegistryObject<Item> PENTAGRAM = ITEMS.register("pentagram",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Test_TAB).stacksTo(64)));
    public static final RegistryObject<Item> RAW_CELESTINE = ITEMS.register("raw_celestine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.Test_TAB).stacksTo(64)));
    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("dice",
            () -> new DiceItem(new Item.Properties().tab(ModCreativeModeTab.Test_TAB).stacksTo(99)));

    public static final RegistryObject<Item> GHAST_Y_SPAWN_EGG= ITEMS.register("ghast_y_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.Ghast_Y, 0x22b341, 0x19732e,
                    new Item.Properties().tab(ModCreativeModeTab.Test_TAB).stacksTo(64)));
    public static final RegistryObject<Item> YAN_SWORD = ITEMS.register("yan_sword",
            () -> new SwordItem(Tiers.IRON,8,-2.2f,new Item.Properties().tab(ModCreativeModeTab.Test_TAB).stacksTo(1)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
