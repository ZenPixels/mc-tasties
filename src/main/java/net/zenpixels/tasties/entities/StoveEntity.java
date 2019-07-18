package net.zenpixels.tasties.entities;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.container.Container;
import net.minecraft.container.CraftingTableContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.recipe.RecipeUnlocker;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StoveEntity extends LockableContainerBlockEntity
        implements SidedInventory, RecipeUnlocker, RecipeInputProvider {

    public static final String ENTITY_ID = "stove_entity";        
    public DefaultedList<ItemStack> inventory;
    private final Map<Identifier, Integer> recipesUsed;
    private static final int[] SLOTS = new int[] { 3, 3 };
    // private final RecipeType<? extends CraftingRecipe> recipeType;

    public StoveEntity(BlockEntityType type) {
        super(type);

        this.recipesUsed = new HashMap<>();
        this.inventory = DefaultedList.create(3, ItemStack.EMPTY);
        // this.recipeType = recipeType_1;
    }

    @Override
    public boolean canPlayerUseInv(PlayerEntity playerEntity_1) {
        if (this.world.getBlockEntity(this.pos) != this) {
            return false;
        } else {
            return playerEntity_1.squaredDistanceTo((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D,
                    (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public int getInvSize() {
        return this.inventory.size();
    }

    @Override
    public ItemStack getInvStack(int int_1) {
        return this.inventory.get(int_1);
    }

    @Override
    public boolean isInvEmpty() {
        Iterator var1 = this.inventory.iterator();

        ItemStack itemStack_1;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            itemStack_1 = (ItemStack) var1.next();
        } while (itemStack_1.isEmpty());

        return false;
    }

    @Override
    public ItemStack removeInvStack(int int_1) {
        return Inventories.removeStack(this.inventory, int_1);
    }

    @Override
    public void setInvStack(int int_1, ItemStack itemStack_1) {
        this.inventory.set(int_1, itemStack_1);
        if (itemStack_1.getCount() > this.getInvMaxStackAmount()) {
            itemStack_1.setCount(this.getInvMaxStackAmount());
        }
    }

    @Override
    public ItemStack takeInvStack(int int_1, int int_2) {
        return Inventories.splitStack(this.inventory, int_1, int_2);
    }

    @Override
    public void clear() {
        this.inventory.clear();
    }

    @Override
    public void provideRecipeInputs(RecipeFinder recipeFinder_1) {
        Iterator var2 = this.inventory.iterator();

        while (var2.hasNext()) {
            ItemStack itemStack_1 = (ItemStack) var2.next();
            recipeFinder_1.addItem(itemStack_1);
        }
    }

    @Override
    public Recipe<?> getLastRecipe() {
        return null;
    }

    @Override
    public void setLastRecipe(Recipe<?> recipe_1) {
        if (recipe_1 != null) {
            this.recipesUsed.compute(recipe_1.getId(),
                    (identifier_1, integer_1) -> 1 + (integer_1 == null ? 0 : integer_1));
        }
    }

    @Override
    public boolean canExtractInvStack(int int_1, ItemStack itemStack_1, Direction direction_1) {
        return false;
    }

    @Override
    public boolean canInsertInvStack(int int_1, ItemStack itemStack_1, Direction direction_1) {
        return this.isValidInvStack(int_1, itemStack_1);
    }

    @Override
    public int[] getInvAvailableSlots(Direction direction_1) {
        return SLOTS;
    }

    @Override
    protected Container createContainer(int int_1, PlayerInventory playerInventory_1) {
        return new CraftingTableContainer(int_1, playerInventory_1);
    }

    @Override
    protected Component getContainerName() {
        return new TranslatableComponent("containter.tasties.stove", new Object[0]);
    }
}