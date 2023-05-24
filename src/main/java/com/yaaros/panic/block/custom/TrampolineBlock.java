package com.yaaros.panic.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class TrampolineBlock extends Block {
    public TrampolineBlock(Properties properties){
        super(properties);
    }

//  This method leads to 4 responses,Main Hand&Off Hand in both Server and Client(2x2)

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof  LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP,600,3
                    ,false,false,false));
        }
        super.stepOn(level, pos, state, entity);
    }
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state,
                              @Nullable BlockEntity entity, ItemStack stack) {
        player.awardStat(Stats.BLOCK_MINED.get(this));
        player.causeFoodExhaustion(0.010F);
        dropResources(state, level, pos, entity, player, stack);
    }
    private void Tips(Player player){
        player.sendSystemMessage(Component.translatable("You feel a bit lighter.").
                withStyle(ChatFormatting.AQUA,ChatFormatting.ITALIC));}
}
