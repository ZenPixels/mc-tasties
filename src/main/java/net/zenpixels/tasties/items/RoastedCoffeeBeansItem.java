package net.zenpixels.tasties.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class RoastedCoffeeBeansItem extends Item {
  public static final String ITEM_ID = "roasted_coffee_beans";

  public RoastedCoffeeBeansItem() {
    super(new Item.Settings().itemGroup(ItemGroup.FOOD));
	}
}
