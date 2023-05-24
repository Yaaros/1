package com.yaaros.panic.client;

import com.yaaros.panic.panic;
import com.yaaros.panic.entity.custom.GhastEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GhastModel extends AnimatedGeoModel<GhastEntity> {
    @Override
    public ResourceLocation getModelResource(GhastEntity object) {
        return new ResourceLocation(panic.MOD_ID, "geo/ghast_y.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GhastEntity object) {
        return new ResourceLocation(panic.MOD_ID, "textures/entity/ghast_y_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GhastEntity animatable) {
        return new ResourceLocation(panic.MOD_ID, "animations/ghast_y.animation.json");
    }
}
