package com.briansmod.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class OompaLoompaBlunt extends ItemFood{
	
	/**
	 * By Making a class called blunt and making the constructor to require the Effect, Duration, how strong the effect is, and how likely the effect is to happen
	 */
	
	public int id;
	public int duration;
	public int amplify;
	
	public int id2;
	public int duaration2;
	public int amplify2;
	
	public OompaLoompaBlunt(int hunger, float saturation, boolean isWolfFood)
	{
		super(hunger, saturation, isWolfFood);
		setAlwaysEdible();
	}
	
	protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_)
    {
        if (!p_77849_2_.isRemote)
        {
        	Random rn = new Random();
        	int answer = rn.nextInt(3);
        	
        	if(answer == 0){
            p_77849_3_.addPotionEffect(new PotionEffect(Potion.hunger.id, 1125, 2));
            p_77849_3_.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1125, 2));
        	}if(answer == 1){
        	p_77849_3_.addPotionEffect(new PotionEffect(Potion.confusion.id, 1125, 2));
        	p_77849_3_.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1125, 2));
        	}if(answer == 2){
        	p_77849_3_.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 2));
        	p_77849_3_.addPotionEffect(new PotionEffect(Potion.resistance.id, 1125, 2));
        	}
        	
        	System.out.println(answer);
        }
        else
        {
            super.onFoodEaten(p_77849_1_, p_77849_2_, p_77849_3_);
        }
    }
	
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.none;
    }
	
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 1;
    }
}