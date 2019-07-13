package net.zenpixels.tasties.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class CoffeeBeansItem extends Item {
  public static final String ITEM_ID = "coffee_beans";

  private static final FoodComponent FOOD_COMPONENT = 
    new FoodComponent.Builder().hunger(1).saturationModifier(0.1F)
      .build();

  public CoffeeBeansItem() {
    super(new Item.Settings().group(ItemGroup.FOOD)
      .food(FOOD_COMPONENT));
	}
}
