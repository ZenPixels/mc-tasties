package net.zenpixels.tasties.blocks;

import net.zenpixels.tasties.TastiesMod;
// import net.zenpixels.tasties.containers.StoveContainer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.container.ContainerProviderRegistry;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class StoveBlock extends Block {
	public static final String BLOCK_ID = "stove";
	private static final DirectionProperty FACING;

	public StoveBlock() {
		super(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL)
				.breakByTool(FabricToolTags.PICKAXES, 0).strength(1.5f, 1.2f).build());

		this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH));
	}

	@Override
    public boolean activate(BlockState state, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (!world.isClient) {
			ContainerProviderRegistry.INSTANCE.openContainer(TastiesMod.STOVE_CONTAINER, player, buf -> {
				buf.writeBlockPos(blockPos);
			});
        }

        return true;
	}

	@Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        return this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite());
	}
	
	@Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactoryBuilder_1) {
        stateFactoryBuilder_1.add(new Property[]{FACING});
	}
	
	static {
        FACING = HorizontalFacingBlock.FACING;
    }
}
