package com.yaaros.panic.entity;

import com.yaaros.panic.entity.custom.GhastEntity;
import com.yaaros.panic.panic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, panic.MOD_ID);
//size->碰撞箱
    public static final RegistryObject<EntityType<GhastEntity>> Ghast_Y =
            ENTITY_TYPES.register("ghast_y",()-> EntityType.Builder.of
                    (GhastEntity::new, MobCategory.MONSTER).
                    sized(0.4f,1.6f).build(new ResourceLocation(panic.MOD_ID,"ghast_y").toString()));
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
