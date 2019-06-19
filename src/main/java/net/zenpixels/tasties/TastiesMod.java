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

  public static final CherryPieItem CHERRY_PIE_ITEM = new CherryPieItem();
  public static final CoffeeItem COFFEE_ITEM = new CoffeeItem();
  public static final CoffeeBeansItem COFFEE_BEANS_ITEM = new CoffeeBeansItem();
  public static final RiceItem RICE_ITEM = new RiceItem();
  public static final RoastedCoffeeBeansItem ROASTED_COFFEE_BEANS_ITEM = new RoastedCoffeeBeansItem();
  public static final SushiItem SUSHI_ITEM = new SushiItem();

  @Override
  public void onInitialize() {
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CherryPieItem.ITEM_ID), CHERRY_PIE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CoffeeItem.ITEM_ID), COFFEE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CoffeeBeansItem.ITEM_ID), COFFEE_BEANS_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, RiceItem.ITEM_ID), RICE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, RoastedCoffeeBeansItem.ITEM_ID), ROASTED_COFFEE_BEANS_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, SushiItem.ITEM_ID), SUSHI_ITEM);
  }
}