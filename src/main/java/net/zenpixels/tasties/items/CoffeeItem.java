package net.zenpixels.tasties.items;

// import java.util.List;
// import net.minecraft.client.item.TooltipContext;
// import net.minecraft.entity.LivingEntity;
// import net.minecraft.entity.player.HungerManager;
// import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.FoodItemSetting;
// import net.minecraft.sound.SoundEvents;
// import net.minecraft.sound.SoundCategory;

// import net.minecraft.util.Hand;
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.util.math.Vec3d;
// import net.minecraft.world.World;

public class CoffeeItem extends Item {
  public static final String ITEM_ID = "coffee";

  private static final FoodItemSetting FOOD_SETTING = 
    new FoodItemSetting.Builder().hunger(2).saturationModifier(0.2F)
      .eatenFast()
      .build();

  public CoffeeItem() {
    super(new Item.Settings().itemGroup(ItemGroup.FOOD)
      .food(FOOD_SETTING));
	}
}