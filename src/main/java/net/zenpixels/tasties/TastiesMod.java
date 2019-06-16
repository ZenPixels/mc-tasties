package net.zenpixels.tasties;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
// import net.minecraft.item.ItemGroup;
// import net.minecraft.item.ItemStack;
import net.zenpixels.tasties.items.*;

public class TastiesMod implements ModInitializer {
  public static final String MOD_ID = "tasties";
	public static final String VERSION = "1.0.0";
	public static final String NAME = "Violet's Tasties";
  public static final Logger LOGGER = LogManager.getLogger("tasties");

  public static final CoffeeItem COFFEE_ITEM = new CoffeeItem();

  @Override
  public void onInitialize() {
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CoffeeItem.ITEM_ID), COFFEE_ITEM);
  }
}