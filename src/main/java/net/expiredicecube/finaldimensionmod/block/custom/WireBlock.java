package net.expiredicecube.finaldimensionmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WireBlock extends HorizontalDirectionalBlock {

    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;

    public static final BooleanProperty ABOVE_EAST = BooleanProperty.create("above_east");
    public static final BooleanProperty ABOVE_WEST = BooleanProperty.create("above_west");
    public static final BooleanProperty ABOVE_NORTH = BooleanProperty.create("above_north");
    public static final BooleanProperty ABOVE_SOUTH = BooleanProperty.create("above_south");

    public WireBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(ABOVE_EAST, false)
                .setValue(ABOVE_WEST, false)
                .setValue(ABOVE_NORTH, false)
                .setValue(ABOVE_SOUTH, false));
    }

    private static final VoxelShape SHAPE =
            Block.box(0,0,0,16,16,16);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockGetter level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        return this.defaultBlockState()
                .setValue(NORTH, isSameBlock(level.getBlockState(pos.north())))
                .setValue(EAST, isSameBlock(level.getBlockState(pos.east())))
                .setValue(SOUTH, isSameBlock(level.getBlockState(pos.south())))
                .setValue(WEST, isSameBlock(level.getBlockState(pos.west())))
                .setValue(ABOVE_EAST, isSameBlock(level.getBlockState(pos.east().above())))
                .setValue(ABOVE_WEST, isSameBlock(level.getBlockState(pos.west().above())))
                .setValue(ABOVE_NORTH, isSameBlock(level.getBlockState(pos.north().above())))
                .setValue(ABOVE_SOUTH, isSameBlock(level.getBlockState(pos.south().above())));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, ABOVE_EAST, ABOVE_WEST, ABOVE_NORTH, ABOVE_SOUTH);
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        boolean north = isSameBlock(world.getBlockState(pos.north()));
        boolean east = isSameBlock(world.getBlockState(pos.east()));
        boolean south = isSameBlock(world.getBlockState(pos.south()));
        boolean west = isSameBlock(world.getBlockState(pos.west()));

        boolean aboveEast = isSameBlock(world.getBlockState(pos.east().above()));
        boolean aboveWest = isSameBlock(world.getBlockState(pos.west().above()));
        boolean aboveNorth = isSameBlock(world.getBlockState(pos.north().above()));
        boolean aboveSouth = isSameBlock(world.getBlockState(pos.south().above()));

        state = state.setValue(NORTH, north)
                .setValue(EAST, east)
                .setValue(SOUTH, south)
                .setValue(WEST, west)
                .setValue(ABOVE_EAST, aboveEast)
                .setValue(ABOVE_WEST, aboveWest)
                .setValue(ABOVE_NORTH, aboveNorth)
                .setValue(ABOVE_SOUTH, aboveSouth);

        world.setBlock(pos, state, 3);
    }

    private boolean isSameBlock(BlockState state) {
        return state.getBlock() instanceof WireBlock;
    }
}
