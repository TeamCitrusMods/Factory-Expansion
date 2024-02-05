package dev.teamcitrusmods.factory_expansion.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlastwallBlock extends Block {

    //this needs to be defined by the time super is called in the constructor
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 7);

    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;

    //TODO: dynamic hitbox
    public static final VoxelShape SHAPE =
            Block.box(2, 0, 2, 14, 16, 14);


    private final Block result;
    private final int maxVariants;

    //storing the max variants of this ver. and the block of the next (vanilla uses blockstates over blocks for this stuff idk why)
    public BlastwallBlock(Properties pProperties, int maxVariants, Block result) {
        super(pProperties);
        this.result = result;
        this.maxVariants = maxVariants;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(VARIANT, 0)
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false));
    }

    // to use when block has only one tile variant
    public BlastwallBlock(Properties pProperties, Block result) {
        super(pProperties);
        this.result = result;
        this.maxVariants = 1;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(VARIANT, 0)
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false));
    }

    // to use when explosion destroys it
    public BlastwallBlock(Properties pProperties) {
        super(pProperties);
        this.result = null;
        this.maxVariants = 1;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(VARIANT, 0)
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public boolean connectsTo(BlockState state) {
        return state.getBlock() instanceof BlastwallBlock;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        // code related to variants
        RandomSource ran = pContext.getLevel().random;
        long dTime = pContext.getLevel().getGameTime() / 10 * 1000;
        ran.setSeed(dTime);
        int n = ran.nextInt(maxVariants);

        //
        return super.getStateForPlacement(pContext)
                .setValue(VARIANT, n)
                .setValue(NORTH, this.connectsTo(pContext.getLevel().getBlockState(pContext.getClickedPos().north())))
                .setValue(EAST, this.connectsTo(pContext.getLevel().getBlockState(pContext.getClickedPos().east())))
                .setValue(SOUTH, this.connectsTo(pContext.getLevel().getBlockState(pContext.getClickedPos().south())))
                .setValue(WEST, this.connectsTo(pContext.getLevel().getBlockState(pContext.getClickedPos().west())));
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        return pState
                .setValue(NORTH, this.connectsTo(pLevel.getBlockState(pCurrentPos.north())))
                .setValue(EAST, this.connectsTo(pLevel.getBlockState(pCurrentPos.east())))
                .setValue(SOUTH, this.connectsTo(pLevel.getBlockState(pCurrentPos.south())))
                .setValue(WEST, this.connectsTo(pLevel.getBlockState(pCurrentPos.west())));
    }

    @Override
    public void wasExploded(Level level, @NotNull BlockPos pos, @NotNull Explosion explosion) {
        if(result == null) {
            super.wasExploded(level, pos, explosion);
            return;
        }

        BlockState newState = result.defaultBlockState();
        //check if result block is a blast result block. If so, randomize the state
        if(result instanceof BlastwallBlock resultBlock) {
            int n = level.random.nextInt(resultBlock.getMaxVariants()); //get the max variants of our result block
            newState = newState.setValue(VARIANT, n); //you have to reassign values for blockstates because idk.
        }
        //set block
        level.setBlockAndUpdate(pos, newState);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newState));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VARIANT, NORTH, EAST, SOUTH, WEST);
    }

    /**
     * Get the max variants of this block. This way, we don't need to store maxVariants of the next block.
     */
    public int getMaxVariants() {
        return maxVariants;
    }
}
