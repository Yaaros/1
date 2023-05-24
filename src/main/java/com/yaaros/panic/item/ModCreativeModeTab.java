package com.yaaros.panic.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab Test_TAB = new CreativeModeTab("test_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CELESTINE.get());
        }
    };
    public static final CreativeModeTab Test_TAB2 = new CreativeModeTab("test_tab_2") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CELESTINE.get());
        }
    };
}
