package net.zenpixels.tasties;

import net.minecraft.util.registry.Registry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
import net.zenpixels.tasties.blocks.*;
import net.zenpixels.tasties.containers.StoveContainer;
// import net.zenpixels.tasties.containers.*;
import net.zenpixels.tasties.items.*;

public class TastiesMod implements ModInitializer {
  public static final String MOD_ID = "tasties";
	public static final String VERSION = "1.0.0";
	public static final String NAME = "Violet's Tasties";
  // public static final Logger LOGGER = LogManager.getLogger("tasties");

  // Items
  public static final CherryPieItem CHERRY_PIE_ITEM = new CherryPieItem();
  public static final CoffeeItem COFFEE_ITEM = new CoffeeItem();
  public static final CoffeeBeansItem COFFEE_BEANS_ITEM = new CoffeeBeansItem();
  public static final RiceItem RICE_ITEM = new RiceItem();
  public static final RoastedCoffeeBeansItem ROASTED_COFFEE_BEANS_ITEM = new RoastedCoffeeBeansItem();
  public static final SushiItem SUSHI_ITEM = new SushiItem();

  // Blocks
  public static final StoveBlock STOVE_BLOCK = new StoveBlock();
  
  // Container Identifiers
  public static final Identifier STOVE_CONTAINER = new Identifier(TastiesMod.MOD_ID, "stove_container");

  // Item Groups
  public static final ItemGroup TASTIES_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "tasties_items"), () -> new ItemStack(COFFEE_ITEM));

  @Override
  public void onInitialize() {
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CherryPieItem.ITEM_ID), CHERRY_PIE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CoffeeItem.ITEM_ID), COFFEE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, CoffeeBeansItem.ITEM_ID), COFFEE_BEANS_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, RiceItem.ITEM_ID), RICE_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, RoastedCoffeeBeansItem.ITEM_ID), ROASTED_COFFEE_BEANS_ITEM);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, SushiItem.ITEM_ID), SUSHI_ITEM);

    ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier(MOD_ID, StoveContainer.CONTAINER_ID), (syncid, identifier, player, buf) -> new StoveContainer(syncid, player.inventory, null));
        
    Registry.register(Registry.BLOCK, new Identifier(MOD_ID, StoveBlock.BLOCK_ID), STOVE_BLOCK);
    Registry.register(Registry.ITEM,new Identifier(MOD_ID, StoveBlock.BLOCK_ID), new BlockItem(STOVE_BLOCK, new Item.Settings().maxCount(1).group(TASTIES_GROUP)));
  }
}