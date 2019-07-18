package net.zenpixels.tasties.blocks;

import net.zenpixels.tasties.TastiesMod;
import net.zenpixels.tasties.entities.StoveEntity;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.container.NameableContainerProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class StoveBlock extends BlockWithEntity {
	public static final String BLOCK_ID = "stove";
	private static final DirectionProperty FACING;

	public StoveBlock() {
		super(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL)
				.breakByTool(FabricToolTags.PICKAXES, 0).strength(1.5f, 1.2f).build());

		this.setDefaultState(this.stateFactory.getDefaultState().with(FACING, Direction.NORTH));
	}

	@Override
    public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1) {
        if (!world_1.isClient) {
            this.openContainer(world_1, blockPos_1, playerEntity_1);
        }

        return true;
	}
	
	private void openContainer(World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1) {
        BlockEntity blockEntity_1 = world_1.getBlockEntity(blockPos_1);
        if (blockEntity_1 instanceof StoveEntity) {
            playerEntity_1.openContainer((NameableContainerProvider)blockEntity_1);
        }
    }

	@Override
    public BlockEntity createBlockEntity(BlockView blockView_1) {
        return new StoveEntity(TastiesMod.STOVE_ENTITY);
    }

	@Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext_1) {
        return this.getDefaultState().with(FACING, itemPlacementContext_1.getPlayerFacing().getOpposite());
	}
	
	@Override
    protected void appendProperties(StateFactory.Builder<Block, BlockState> stateFactoryBuilder_1) {
        stateFactoryBuilder_1.add(new Property[]{FACING});
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState_1) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onBlockRemoved(BlockState blockState_1, World world_1, BlockPos blockPos_1, BlockState blockState_2, boolean boolean_1) {
        if (blockState_1.getBlock() != blockState_2.getBlock()) {
            BlockEntity blockEntity_1 = world_1.getBlockEntity(blockPos_1);
            if (blockEntity_1 instanceof StoveEntity) {
                ItemScatterer.spawn(world_1, blockPos_1, (StoveEntity)blockEntity_1);
                world_1.updateHorizontalAdjacent(blockPos_1, this);
            }

            super.onBlockRemoved(blockState_1, world_1, blockPos_1, blockState_2, boolean_1);
        }
    }
	
	static {
        FACING = HorizontalFacingBlock.FACING;
    }
}
