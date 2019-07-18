package net.zenpixels.tasties;

import net.minecraft.util.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import net.zenpixels.tasties.blocks.*;
import net.zenpixels.tasties.entities.StoveEntity;
import net.zenpixels.tasties.init.Items;
import net.zenpixels.tasties.items.StoveItem;

public class TastiesMod implements ModInitializer {
  public static final String MOD_ID = "tasties";
	public static final String VERSION = "1.0.0";
  public static final String NAME = "Violet's Tasties";
  
  // Blocks
  public static final StoveBlock STOVE_BLOCK = new StoveBlock();

  // Entities
  public static BlockEntityType<StoveEntity> STOVE_ENTITY = BlockEntityType.Builder.create(() -> new StoveEntity(TastiesMod.STOVE_ENTITY), new Block[]{STOVE_BLOCK}).build(null);

  // Items
  public static final StoveItem STOVE_ITEM = new StoveItem(STOVE_BLOCK);

  @Override
  public void onInitialize() {
    Registry.register(Registry.BLOCK_ENTITY, new Identifier(MOD_ID, StoveEntity.ENTITY_ID), STOVE_ENTITY);
    Registry.register(Registry.BLOCK, new Identifier(MOD_ID, StoveBlock.BLOCK_ID), STOVE_BLOCK);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, StoveItem.ITEM_ID), STOVE_ITEM);
  
    Items.register();
  }
}