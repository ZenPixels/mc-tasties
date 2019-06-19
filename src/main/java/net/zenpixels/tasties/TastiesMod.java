package net.zenpixels.tasties;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.zenpixels.tasties.items.*;

public class TastiesMod implements ModInitializer {
  public static final String MOD_ID = "tasties";
	public static final String VERSION = "1.0.0";
	public static final String NAME = "Violet's Tasties";
  public static final Logger LOGGER = LogManager.getLogger("tasties");

  public static final CoffeeItem COFFEE_ITEM = new CoffeeItem();
  public static final CoffeeBeansItem COFFEE_BEANS_ITEM = new CoffeeBeansItem();
  public static final RoastedCoffeeBeansItem ROASTED_COFFEE_BEANS_ITEM = new RoastedCoffeeBeansItem();

  @Override
  public void onInitialize() {
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CoffeeItem.ITEM_ID), COFFEE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CoffeeBeansItem.ITEM_ID), COFFEE_BEANS_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, RoastedCoffeeBeansItem.ITEM_ID), ROASTED_COFFEE_BEANS_ITEM);
  }
}