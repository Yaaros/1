package com.yaaros.panic.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.yaaros.panic.entity.custom.GhastEntity;
import com.yaaros.panic.panic;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GhastRenderer extends GeoEntityRenderer<GhastEntity> {
    public GhastRenderer(EntityRendererProvider.Context rendererManager){
        super(rendererManager,new GhastModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(GhastEntity instance) {
        return new ResourceLocation(panic.MOD_ID, "textures/entity/ghast_y_texture.png");
    }

    @Override
    public RenderType getRenderType(GhastEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {

        stack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
