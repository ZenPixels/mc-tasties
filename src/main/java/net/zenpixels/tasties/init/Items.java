package net.zenpixels.tasties.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zenpixels.tasties.TastiesMod;
import net.zenpixels.tasties.items.*;

public class Items {
    public static final ItemGroup TASTIES_GROUP = FabricItemGroupBuilder.build(new Identifier(TastiesMod.MOD_ID, "tasties_items"), () -> new ItemStack(Registry.ITEM.get(new Identifier("minecraft:cake"))));
    
    // Base Items
    private static final BaseItem ROASTED_COFFEE_BEANS_ITEM = new BaseItem("roasted_coffee_beans");

    // Base Food Items
    private static final BaseFoodItem CHERRY_PIE_ITEM = new BaseFoodItem("cherry_pie", 3, 0.1F, TASTIES_GROUP);
    private static final BaseFoodItem COFFEE_BEANS_ITEM = new BaseFoodItem("coffee_beans", 1, 0.1F, TASTIES_GROUP);
    private static final BaseFoodItem RICE_ITEM = new BaseFoodItem("rice", 1, 0.1F, TASTIES_GROUP);
    private static final BaseFoodItem SUSHI_ITEM = new BaseFoodItem("sushi", 3, 0.3F, TASTIES_GROUP);

    // Fancy Items
    private static final BaseFoodItem COFFEE_ITEM = new BaseFoodItem("coffee", 3, 0.3F, TASTIES_GROUP, 
        new StatusEffectInstance(StatusEffects.SPEED, 2000, 1));

    public static void register() {
        register(CHERRY_PIE_ITEM.itemID, CHERRY_PIE_ITEM);
        register(COFFEE_ITEM.itemID, COFFEE_ITEM);
        register(COFFEE_BEANS_ITEM.itemID, COFFEE_BEANS_ITEM);
        register(RICE_ITEM.itemID, RICE_ITEM);
        register(ROASTED_COFFEE_BEANS_ITEM.itemID, ROASTED_COFFEE_BEANS_ITEM);
        register(SUSHI_ITEM.itemID, SUSHI_ITEM);
    }

    private static void register(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(TastiesMod.MOD_ID, name), item);
    }
}