package net.zenpixels.tasties.items;

import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class BaseFoodItem extends BaseItem {
    private StatusEffectInstance statusEffect = null;

    public BaseFoodItem(String id, int hunger, float saturationModifier) {   
        this(id, hunger, saturationModifier, ItemGroup.FOOD);
    } 
    
    public BaseFoodItem(String id, int hunger, float saturationModifier, ItemGroup itemGroup) {
        this(id, 
            new Item.Settings()
            .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturationModifier).build())
            .group(itemGroup));
    }

    public BaseFoodItem(String id, int hunger, float saturationModifier, ItemGroup itemGroup, StatusEffectInstance statusEffectInstance) {
        this(id, 
            new Item.Settings()
            .food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturationModifier).build())
            .group(itemGroup));

        statusEffect = statusEffectInstance;
    }
    
    public BaseFoodItem(String id, Settings itemSettings) {
        super(id, itemSettings);
    }

    @Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity entity) {
    if (entity instanceof PlayerEntity && statusEffect != null) {
        PlayerEntity player = (PlayerEntity) entity;
        player.addPotionEffect(statusEffect);
        if (player instanceof ServerPlayerEntity) {
            Criterions.CONSUME_ITEM.handle((ServerPlayerEntity) player, stack);
        }
    }

    stack.decrement(1);

    return stack;
  }
}
