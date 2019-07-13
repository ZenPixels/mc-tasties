package net.zenpixels.tasties.containers;

import net.zenpixels.tasties.TastiesMod;
import net.minecraft.container.BlockContext;
import net.minecraft.container.CraftingTableContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;

public class StoveContainer extends CraftingTableContainer {
    public static final String CONTAINER_ID = "stove_container";
    // private final BlockContext context;

    public StoveContainer(int int1, PlayerInventory inventory, BlockContext blockContext) {
        super(int1, inventory, blockContext);

        // this.context = blockContext;
    }

    @Override
    public boolean canUse(PlayerEntity playerEntity) {
        return true;

        //  return canUse(this.context, playerEntity, TastiesMod.STOVE_BLOCK);
    }
}
