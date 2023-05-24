package com.yaaros.panic.villager;

import com.google.common.collect.ImmutableSet;
import com.yaaros.panic.block.ModBlocks;
import com.yaaros.panic.panic;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, panic.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS=
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS,panic.MOD_ID);
    public static final RegistryObject<PoiType> Trampoline_POI = POI_TYPES.register("trampoline_poi",
            ()-> new PoiType(ImmutableSet.copyOf
                    (ModBlocks.Trampoline.get().getStateDefinition().getPossibleStates()),1,1));
    public static final RegistryObject<PoiType> Pentagram_POI = POI_TYPES.register("pentagram_poi",
            ()-> new PoiType(ImmutableSet.copyOf
                    (ModBlocks.Pentagram_Enchanting_Table.get().getStateDefinition().getPossibleStates()),1,2));
    public static final RegistryObject<VillagerProfession> Wizard = VILLAGER_PROFESSIONS.
            register("wizard",()-> new VillagerProfession("wizard",
                    x -> x.get() == Trampoline_POI.get(),x -> x.get() == Trampoline_POI.get(),
                    ImmutableSet.of(),ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CLERIC));
    public static final RegistryObject<VillagerProfession> Lexicy = VILLAGER_PROFESSIONS.
            register("lexicy",()-> new VillagerProfession("lexicy",
                    x -> x.get() == Pentagram_POI.get(),x -> x.get() == Pentagram_POI.get(),
                    ImmutableSet.of(),ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CLERIC));

    public static void registerPOIs(){
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates",PoiType.class).invoke(null,Trampoline_POI.get());
        }catch (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates",PoiType.class).invoke(null,Pentagram_POI.get());
        }catch (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
