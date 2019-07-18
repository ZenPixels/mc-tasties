package net.zenpixels.tasties.items;

import net.zenpixels.tasties.blocks.StoveBlock;
import net.zenpixels.tasties.init.Items;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class StoveItem extends BlockItem {
    public static final String ITEM_ID = "stove";

    public StoveItem(StoveBlock block) {
        this(block, new Item.Settings().group(Items.TASTIES_GROUP));
    }

    public StoveItem(StoveBlock block, Settings settings) {
        super(block, settings);
    }
}
