package net.zenpixels.tasties.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CoffeeItem extends Item {
  public static final String ITEM_ID = "coffee";

  private static final FoodComponent FOOD_COMPONENT = 
    new FoodComponent.Builder().hunger(2).saturationModifier(0.2F)
      .alwaysEdible()
      .build();

  public CoffeeItem() {
    super(new Item.Settings().group(ItemGroup.FOOD)
      .food(FOOD_COMPONENT));
  }
  
  protected void onFoodEaten(ItemStack stack, World world, PlayerEntity player) {
    if (!world.isClient) {
      player.addPotionEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 10, true, true, false));
    }
  }
}
