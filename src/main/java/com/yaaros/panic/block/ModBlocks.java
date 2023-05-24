package com.yaaros.panic.block;

import com.yaaros.panic.block.custom.CelestineLampBlock;
import com.yaaros.panic.block.custom.TrampolineBlock;
import com.yaaros.panic.item.ModCreativeModeTab;
import com.yaaros.panic.item.ModItems;
import com.yaaros.panic.panic;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, panic.MOD_ID);

    public static final RegistryObject<Block> CELESTINE_BLOCK = registerBlock("celestine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS).
                    strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.Test_TAB);
    //Material.GLASS 处的描述意为质感，联系到踩上去的声音
    //lightLevel()为什么传参类型为double、float、int都不行?
    public static final RegistryObject<Block> CELESTINE_ORE = registerBlock("celestine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).
                    strength(5f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.Test_TAB);
    //这里设置成可以掉经验的方块，UniformInt方法是经验量区间[3,7]

    public static final RegistryObject<Block> DEEPSLATE_CELESTINE_ORE =
            registerBlock("deepslate_celestine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).
                    strength(7f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,8)), ModCreativeModeTab.Test_TAB);
    public static final RegistryObject<Block> END_CELESTINE_ORE =
            registerBlock("end_celestine_ore",
                    () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).
                            strength(7f).requiresCorrectToolForDrops(),
                            UniformInt.of(3,8)), ModCreativeModeTab.Test_TAB);
    public static final RegistryObject<Block> Trampoline = registerBlock("trampoline",
            () -> new TrampolineBlock(BlockBehaviour.Properties.of(Material.CLAY).
                    strength(3f)), ModCreativeModeTab.Test_TAB);
    //灯这里切换15亮度 和 0亮度
    public static final RegistryObject<Block> Celestine_Lamp = registerBlock("celestine_lamp",
            () -> new CelestineLampBlock(BlockBehaviour.Properties.of(Material.GLASS).
                    strength(4f).lightLevel(state -> state.getValue(CelestineLampBlock.LIT)?15 : 0)), ModCreativeModeTab.Test_TAB);
    public static final RegistryObject<Block> Pentagram_Enchanting_Table= registerBlock("pentagram_enchanting_table",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).
                    strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.Test_TAB);
    private static <T extends Block>RegistryObject<T>
    registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name,toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item>
    registerBlockItem(String name,RegistryObject<T> block,CreativeModeTab tab){

        return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){

        BLOCKS.register(eventBus);
    }
}
