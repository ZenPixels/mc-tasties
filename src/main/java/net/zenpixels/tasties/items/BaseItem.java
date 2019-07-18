package net.zenpixels.tasties.items;

import net.zenpixels.tasties.init.Items;
import net.minecraft.item.Item;

public class BaseItem extends Item {
    public String itemID;

    public BaseItem(String id) {
        this(id, new Item.Settings().group(Items.TASTIES_GROUP));
	} 

    public BaseItem(String id, Settings itemSettings) {
        super(itemSettings);

        itemID = id;
    }
}
