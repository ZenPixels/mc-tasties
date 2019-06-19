package net.zenpixels.tasties.items;

import net.minecraft.item.FoodItemSetting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class RiceItem extends Item {
  public static final String ITEM_ID = "rice";

  private static final FoodItemSetting FOOD_SETTING = 
    new FoodItemSetting.Builder().hunger(1).saturationModifier(0.1F)
      .eatenFast()
      .build();

  public RiceItem() {
    super(new Item.Settings().itemGroup(ItemGroup.FOOD)
      .food(FOOD_SETTING));
	}
}
