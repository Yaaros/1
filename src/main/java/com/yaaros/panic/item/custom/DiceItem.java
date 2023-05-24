package com.yaaros.panic.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DiceItem extends Item {
    public DiceItem(Properties properties){
        super(properties);
    }
//shift+F6改变形参名字
    //use方法表示右键会发生的事件
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        //在服务端生成随机数
        if(!level.isClientSide()&&hand==InteractionHand.MAIN_HAND) {
            //Output a random number
            OutputRandomNumber(player);
            //Set a Cooldown
            player.getCooldowns().addCooldown(this,30);
        }
            return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            components.add(Component.translatable("Right Click to get a random number between 1 and 6").
                    withStyle(ChatFormatting.GOLD,ChatFormatting.ITALIC));

        } else{
            components.add(Component.translatable("Press SHIFT for more info").
                    withStyle(ChatFormatting.AQUA,ChatFormatting.UNDERLINE));

        }

        super.appendHoverText(stack, level, components, flag);
    }

    private void OutputRandomNumber(Player player){
        player.sendSystemMessage(Component.translatable("Your Number is "+getRandomNumber()).
                withStyle(ChatFormatting.GOLD,ChatFormatting.UNDERLINE));
    }
    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(1,7);
    }
}
