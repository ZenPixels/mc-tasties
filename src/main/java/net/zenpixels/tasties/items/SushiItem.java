package net.zenpixels.tasties.items;

import net.zenpixels.tasties.TastiesMod;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class SushiItem extends Item {
  public static final String ITEM_ID = "sushi";

  private static final FoodComponent FOOD_COMPONENT = 
    new FoodComponent.Builder().hunger(3).saturationModifier(0.1F)
      .build();

  public SushiItem() {
    super(new Item.Settings().group(ItemGroup.FOOD)
      .food(FOOD_COMPONENT)
      .group(TastiesMod.TASTIES_GROUP));
	}
}
